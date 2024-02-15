package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rubypaper.domain.Course;
import com.rubypaper.domain.Enrol;
import com.rubypaper.domain.EnrolRepository;
import com.rubypaper.domain.Student;
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
//			System.out.println(sum +  " : " + avg);
//			System.out.println(m);
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
	
	@GetMapping("/studentForm.do")
	String studentForm() {
		
		return "/student/studentForm.html";
	}
	
	@GetMapping("/studentInsert.do")
	String studentInsert(Student student) {
		
		service.studentInsert(student);
		
		return "redirect:/getStudentList.do";
	}
	
	
	@GetMapping("/enrolForm.do")
	String enrolForm(Model model, Enrol enrol) {
		String sno = enrol.getSno();
		
		model.addAttribute("sno", sno);
		model.addAttribute("li", service.getCourseList());
		
		return "/student/enrolForm.html";
	}
	
	@PostMapping("/enrolInsert.do")
	String enrolInsert(Enrol enrol,Student student, Course course) {

		enrol.setStudent(student);
		enrol.setCourse(course);
		
		System.out.println(enrol + ":" + enrol.getStudent().getSno() + ":" +
				enrol.getCourse().getCno());

		service.enrolInsert(enrol);
		
	    return "redirect:/getEnrolList.do";
	}
	
	@GetMapping("/deleteStudent.do")
	String deleteStudent(@RequestParam("sno") String sno) {
		
		service.deleteStudent(sno);
		
		return "redirect:/getStudentList.do";
	}
	
	@GetMapping("/deleteBySnoAndCno.do")
	String deleteBySnoAndCno(String sno, String cno) {
		
		Enrol enrol = service.findBySnoAndCno(sno, cno);
		System.out.println("@@@@@@@@enrol: " + enrol);
//		@@@@@@@@enrol: Enrol [sno=400, cno=C123, grade=A, mscore=90, fscore=90]
		service.deleteT(enrol);
		// 동일 sno의 레코드와 student, course까지 모두 삭제 됨
		
		return "redirect:/getEnrolList.do";
	}
	
	@GetMapping("/deleteByCnoAndSno.do")
	String deleteByCnoAndSno(String cno, String sno) {
		
		Enrol enrol = service.findByCnoAndSno(cno, sno);
		System.out.println("@@@@@@@@enrol: " + enrol);
//		@@@@@@@@enrol: Enrol [sno=400, cno=C123, grade=A, mscore=90, fscore=90]
		service.deleteT(enrol);
		// id의 위치를 바꾸어도 동일 sno가 모두 삭제 됨
		
		return "redirect:/getEnrolList.do";
	}
	
	@GetMapping("/deleteByCno.do")
	String deleteByCno(String cno, String sno) {
		
		List<Enrol> enrol = service.findByCno(cno);
//		System.out.println("@@@@@@@@enrol: " + enrol);
//		@@@@@@@@enrol: [Enrol [sno=300, cno=C312, grade=A, mscore=90, fscore=95],
//		Enrol [sno=400, cno=C312, grade=A, mscore=90, fscore=95], Enrol [sno=500,
//		cno=C312, grade=B, mscore=85, fscore=80]]
		service.deleteCno(enrol); // null 
		
//		List<Enrol> enrol2 = service.findBySno(sno);
//		System.out.println("@@@@@@@@enrol: " + enrol2);
//		@@@@@@@@enrol: [Enrol [sno=400, cno=C324, grade=A, mscore=95, fscore=90],
//		                Enrol [sno=400, cno=C413, grade=B, mscore=80, fscore=85],
//		                Enrol [sno=400, cno=E412, grade=C, mscore=65, fscore=75],
//		                Enrol [sno=400, cno=C123, grade=A, mscore=90, fscore=90],
//		                Enrol [sno=400, cno=C312, grade=A, mscore=90, fscore=95]]
		
//		service.deleteCno(enrol2);
		
		return "redirect:/getEnrolList.do";
	}
	
	
	@GetMapping("/deleteQuery.do")
	String deleteQuery() {
		
		service.deleteQuery();
		
		return "redirect:/getEnrolList.do";
	}

}