package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rubypaper.domain.Enrol;
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
	
	@GetMapping("/getEnrolList.do")
	String getEnrolList(Model model) {
		
		List<Enrol> li = service.getEnrolList();
		
		int sum = 0;
		double avg = 0;
		for(Enrol m : li) {
			int mscore = Integer.parseInt(m.getMscore());
			int fscore = Integer.parseInt(m.getFscore());
			sum = mscore + fscore;
			m.setScoreSum(sum);
			avg = (double) sum / 2;
			m.setScoreAvg(avg);
			System.out.println(sum +  " : " + avg);
			System.out.println(m);
		}
		
		model.addAttribute("li", service.getEnrolList());
		
		return "/student/getEnrolList.html";
	}
	
	@GetMapping("/getEnrol.do")
	String getStudent(Enrol enrol, Model model) {
		String sno = enrol.getSno();
		model.addAttribute("li", service.getEnrol(sno));
		
		return "/student/getEnrol.html";
	}
}
