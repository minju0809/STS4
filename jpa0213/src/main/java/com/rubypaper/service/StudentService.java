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
	
	Enrol findBySnoAndCno(String sno, String cno);
	Enrol findByCnoAndSno(String cno, String sno);
	List<Enrol> findByCno(String cno);
	List<Enrol> findBySno(String sno);
	
	void deleteT(Enrol enrol);
	void deleteCno(List<Enrol> enrol);
	
	void deleteQuery();
	
	void deleteCheck(String sno, String cno);
}
