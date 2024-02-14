package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.rubypaper.domain.Student;
import com.rubypaper.domain.StudentRepository;

@Controller
public class StartController {
	

	
	@GetMapping("/index2.do")
	String index2() {
		System.out.println("==> index2.do 확인");
		

		
		return "/index2.html";
	}
}
