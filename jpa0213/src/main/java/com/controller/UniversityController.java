package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rubypaper.service.StudentService;

@Controller
public class UniversityController {
	
	@Autowired
	private StudentService service;

	@GetMapping("/getStudentList.do")
	String getStudentList(Model model) {
		
		model.addAttribute("li", service.getStudentList());
		
		return "/student/getStudentList.html";
	}
}
