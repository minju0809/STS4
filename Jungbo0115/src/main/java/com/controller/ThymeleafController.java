package com.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.rubypaper.login.LoginService;
import com.rubypaper.login.LoginVO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ThymeleafController {

  @Autowired
  private LoginService service;

  @Autowired
  private PasswordEncoder encoder;

  @Autowired
  HttpServletRequest request;

  @GetMapping("/main")
  public void index(Model model) {
    model.addAttribute("hello", "안녕하세요 타임리프입니다");
  }

  @GetMapping("/getUserList")
  public void getUserList(Model model) {
    model.addAttribute("li", service.getUserList(null));
  }

  @GetMapping("/getUser")
  public void getUser(Model model, LoginVO vo) {
    model.addAttribute("user", service.getUser(vo));
  }

  @GetMapping("/member/userForm")
  public String userForm() {

    return "userForm";
  }

  @PostMapping("/insert")
  public String insert(Model model, LoginVO vo) throws Exception {
    String path = request.getSession().getServletContext().getRealPath("/img/");
    System.out.println("path: " + path);
    // C:\Users\4545\Desktop\Jungbo\Jungbo0115\src\main\webapp\img\

    int random = (int) (Math.random() * 999999) + 100001;

    MultipartFile file = vo.getFile(); // 실제 파일
    String fileName = file.getOriginalFilename();
    File f = new File(path + fileName);

    if (!file.isEmpty()) {
      if (f.exists()) {
        String fName = fileName.substring(0, fileName.lastIndexOf("."));
        String lName = fileName.substring(fileName.lastIndexOf("."));
        fileName = fName + "_" + random + lName;
      }
    } else {
      fileName = "space.png";
    }

    vo.setFileStr(fileName);
    file.transferTo(new File(path + fileName));

    vo.setPassword(encoder.encode(vo.getPassword()));
    vo.setRole("ROLE_" + vo.getRole().toUpperCase());
    service.insert(vo);

    return "redirect:/getUserList";
  }

  @GetMapping("/update")
  public String update(Model model, LoginVO vo) {
    vo.setRole("ROLE_" + vo.getRole().toUpperCase());
    service.update(vo);

    return "redirect:/getUserList";
  }
}
