package com.rubypaper.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.rubypaper.project.psd.PsdService;
import com.rubypaper.project.psd.PsdVO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PsdController {
	
	@Autowired
	private PsdService service;
	
	@Autowired
	private HttpServletRequest request;
	
	@GetMapping("getPsdList.do")
	String getPsdList(Model model) {
		model.addAttribute("li", service.getPsdList(null));
		
		return "/psd/getPsdList";
	}

	@GetMapping("psdForm.do")
	String psdForm() {
		System.out.println("form");
		return "/psd/psdForm";
	}
	
	@PostMapping("psdInsert.do")
	String psdInsert(PsdVO vo) throws Exception, IOException {
		System.out.println("저장하기");
		
		String path = request.getSession().getServletContext().getRealPath("/psd/img/");
		
		System.out.println("path: "+path);
		
		MultipartFile file = vo.getImg();
		String fileName = file.getOriginalFilename();
		file.transferTo(new File(path+fileName));
		
		vo.setImgStr(fileName);
		
		service.insert(vo);
		
		return "redirect:getPsdList.do";
	}
	
}
