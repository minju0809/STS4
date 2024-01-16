package com.rubypaper.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

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
		
		String path = request.getSession().getServletContext().getRealPath("/psd/img/");
		System.out.println("path: "+path);
		
		// 중복 처리 (시간)
		long time = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		String sdfStr = sdf.format(time);
		
		
		MultipartFile file = vo.getImg(); // 파일 
		String fileName = file.getOriginalFilename();
		
		File f = new File(path+fileName); // 경로 안에 있는 파일
		
		if(!file.isEmpty()) {
			if(f.exists()) {
				String onlyFileName = fileName.substring(0, fileName.lastIndexOf("."));
				String ext = fileName.substring(fileName.lastIndexOf("."));
				
				fileName = onlyFileName + "_" + sdfStr + ext;
			} 
			// 실제 파일 저장
			file.transferTo(new File(path+fileName));
		} else {
			fileName = "space.png";
		}
		
		vo.setImgStr(fileName); // 테이블에 파일 이름 저장
		
		service.insert(vo);
		
		return "redirect:getPsdList.do";
	}
	
}
