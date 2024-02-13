package com.rubypaper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rubypaper.domain.CourseRepository;
import com.rubypaper.domain.Enrol;
import com.rubypaper.domain.EnrolRepository;
import com.rubypaper.domain.Student;
import com.rubypaper.domain.StudentRepository;

@SpringBootTest
public class SCEMappingTest {

	@Autowired 
	private StudentRepository studentRepo;
	
	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
	private EnrolRepository enrolRepo;
	
	@Test
	void contextLoads() {
//		Enrol enrol = enrolRepo.findById(null).get();
//		System.out.println(enrol.getStudent().getSname());
//		System.out.println(enrol.getCourse().getCname());
//
//		Student student = studentRepo.findById(null).get();
//		List<Enrol> li = student.getEnrolList();
//		
//		for(Enrol e : li) {
//			System.out.println("==> " + e.toString());
//		}
	}
}
