package com.rubypaper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubypaper.domain.Enrol;
import com.rubypaper.domain.EnrolRepository;
import com.rubypaper.domain.Student;
import com.rubypaper.domain.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private EnrolRepository enrolRepo;
	
	@Override
	public List<Student> getStudentList() {
		return (List<Student>) studentRepo.findAll();
	}

	@Override
	public List<Enrol> getEnrolList() {
		
		return (List<Enrol>) enrolRepo.findAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Enrol> getEnrol(String sno) {
		return (List<Enrol>) enrolRepo.findBySno(sno);
	}

}
