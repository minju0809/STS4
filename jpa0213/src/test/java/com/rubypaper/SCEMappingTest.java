package com.rubypaper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rubypaper.domain.Course;
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
//		Course course = courseRepo.findById("C123").get();
////		course.setCname("C언어");
//		course.setCno("CCC123"); // pk를 수정할 경우, 기존 레코드 그대로 남아있고, 새로 insert가 됨
//		courseRepo.save(course);
//		
		Student student = studentRepo.findById("300").get();
		student.setSno("301");
		studentRepo.save(
				student);
		
//		studentRepo.deleteById("400");
	}
}
