package com.rubypaper.service;

import java.util.List;

import com.rubypaper.domain.Enrol;
import com.rubypaper.domain.Student;

public interface StudentService {
	List<Student> getStudentList();
	
	List<Enrol> getEnrolList();
	
	List<Enrol> getEnrol(String sno);
}
