package com.rubypaper;

import java.util.Date;

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
class Jpa0213ApplicationInsertTests {
	
	@Autowired 
	private StudentRepository studentRepo;
	
	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
	private EnrolRepository enrolRepo;
	
	@Test
	void contextLoads() {
		Student	student1 = new  Student();
		student1.setSno("100");
		student1.setSname("나연묵");
		student1.setDept("컴퓨터");
		student1.setYear("4");
		
		Student	student2 = new  Student();
		student2.setSno("200");
		student2.setSname("이찬영");
		student2.setDept("전기");
		student2.setYear("3");
		
		Student	student3 = new  Student();
		student3.setSno("300");
		student3.setSname("정기태");
		student3.setDept("컴퓨터");
		student3.setYear("1");
		
		Student	student4 = new  Student();
		student4.setSno("400");
		student4.setSname("송병호");
		student4.setDept("컴퓨터");
		student4.setYear("4");
		
		Student	student5 = new  Student();
		student5.setSno("500");
		student5.setSname("박종화");
		student5.setDept("산공");
		student5.setYear("2");

		studentRepo.save(student1);
		studentRepo.save(student2);
		studentRepo.save(student3);
		studentRepo.save(student4);
		studentRepo.save(student5);
		
		
		Course	course1 = new  Course();
		course1.setCno("C123");
		course1.setCname("프로그래밍");
		course1.setCredit("3");
		course1.setDept("컴퓨터");
		course1.setPrname("김성기");
	
		Course	course2 = new  Course();
		course2.setCno("C312");
		course2.setCname("자료구조");
		course2.setCredit("3");
		course2.setDept("컴퓨터");
		course2.setPrname("황수찬");
	
		Course	course3 = new  Course();
		course3.setCno("C324");
		course3.setCname("화일처리");
		course3.setCredit("3");
		course3.setDept("컴퓨터");
		course3.setPrname("이규철");
	
		Course	course4 = new  Course();
		course4.setCno("C413");
		course4.setCname("데이터베이스");
		course4.setCredit("3");
		course4.setDept("컴퓨터");
		course4.setPrname("이성호");
	
		Course	course5 = new  Course();
		course5.setCno("E412");
		course5.setCname("반도체");
		course5.setCredit("3");
		course5.setDept("전자");
		course5.setPrname("홍봉희");
	
		courseRepo.save(course1);
		courseRepo.save(course2);
		courseRepo.save(course3);
		courseRepo.save(course4);
		courseRepo.save(course5);
		
		Enrol enrol1= new  Enrol();
		enrol1.setSno("100");
		enrol1.setCno("C413");
		enrol1.setGrade("A");
		enrol1.setMscore("90");
		enrol1.setFscore("95");
		enrol1.setStudent(student1);
		enrol1.setCourse(course4);

		Enrol enrol2= new  Enrol();
		enrol2.setSno("100");
		enrol2.setCno("E412");
		enrol2.setGrade("A");
		enrol2.setMscore("95");
		enrol2.setFscore("95");
		enrol2.setStudent(student1);
		enrol2.setCourse(course5);
		
		Enrol enrol3= new  Enrol();
		enrol3.setSno("200");
		enrol3.setCno("C123");
		enrol3.setGrade("B");
		enrol3.setMscore("85");
		enrol3.setFscore("80");
		enrol3.setStudent(student2);
		enrol3.setCourse(course1);
		
		Enrol enrol4= new  Enrol();
		enrol4.setSno("300");
		enrol4.setCno("C312");
		enrol4.setGrade("A");
		enrol4.setMscore("90");
		enrol4.setFscore("95");
		enrol4.setStudent(student3);
		enrol4.setCourse(course2);
		
		Enrol enrol5= new  Enrol();
		enrol5.setSno("300");
		enrol5.setCno("C324");
		enrol5.setGrade("C");
		enrol5.setMscore("75");
		enrol5.setFscore("75");
		enrol5.setStudent(student3);
		enrol5.setCourse(course3);
		
		Enrol enrol6= new  Enrol();
		enrol6.setSno("300");
		enrol6.setCno("C413");
		enrol6.setGrade("A");
		enrol6.setMscore("95");
		enrol6.setFscore("90");
		enrol6.setStudent(student3);
		enrol6.setCourse(course4);
		
		Enrol enrol7= new  Enrol();
		enrol7.setSno("400");
		enrol7.setCno("C312");
		enrol7.setGrade("A");
		enrol7.setMscore("90");
		enrol7.setFscore("95");
		enrol7.setStudent(student4);
		enrol7.setCourse(course2);
		
		// values('400','C324','A',95,90);
		Enrol enrol8= new  Enrol();
		enrol8.setSno("400");
		enrol8.setCno("C324");
		enrol8.setGrade("A");
		enrol8.setMscore("95");
		enrol8.setFscore("90");
		enrol8.setStudent(student4);
		enrol8.setCourse(course3);
		
		// values('400','C413','B',80,85);
		Enrol enrol9= new  Enrol();
		enrol9.setSno("400");
		enrol9.setCno("C413");
		enrol9.setGrade("B");
		enrol9.setMscore("80");
		enrol9.setFscore("85");
		enrol9.setStudent(student4);
		enrol9.setCourse(course4);
		
		// values('400','E412','C',65,75);
		Enrol enrol10= new  Enrol();
		enrol10.setSno("400");
		enrol10.setCno("E412");
		enrol10.setGrade("C");
		enrol10.setMscore("65");
		enrol10.setFscore("75");
		enrol10.setStudent(student4);
		enrol10.setCourse(course5);
		
		// values('500','C312','B',85,80);
		Enrol enrol11= new  Enrol();
		enrol11.setSno("500");
		enrol11.setCno("C312");
		enrol11.setGrade("B");
		enrol11.setMscore("85");
		enrol11.setFscore("80");
		enrol11.setStudent(student5);
		enrol11.setCourse(course2);
		
		// values('400','C123','A',90,90);
		Enrol enrol12= new  Enrol();
		enrol12.setSno("400");
		enrol12.setCno("C123");
		enrol12.setGrade("A");
		enrol12.setMscore("90");
		enrol12.setFscore("90");
		enrol12.setStudent(student4);
		enrol12.setCourse(course1);
		
		enrolRepo.save(enrol1);
		enrolRepo.save(enrol2);
		enrolRepo.save(enrol3);
		enrolRepo.save(enrol4);
		enrolRepo.save(enrol5);
		enrolRepo.save(enrol6);
		enrolRepo.save(enrol7);
		enrolRepo.save(enrol8);
		enrolRepo.save(enrol9);
		enrolRepo.save(enrol10);
		enrolRepo.save(enrol11);
		enrolRepo.save(enrol12);
		
	}

}
