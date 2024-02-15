package com.rubypaper.service;

import java.util.List;

import com.rubypaper.domain.Course;
import com.rubypaper.domain.Enrol;
import com.rubypaper.domain.Student;

public interface StudentService {
	List<Student> getStudentList();
	
	List<Enrol> getEnrolList();
	
	List<Enrol> getEnrol(String sno);
	
	void studentInsert(Student student);
	
	void enrolInsert(Enrol enrol);
	
	List<Course> getCourseList();
	
	Student getStudent(String sno);
	
	Course getCourse(String cno);
	
	void deleteStudent(String sno);
}
