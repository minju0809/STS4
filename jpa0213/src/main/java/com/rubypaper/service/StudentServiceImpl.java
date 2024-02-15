package com.rubypaper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubypaper.domain.Course;
import com.rubypaper.domain.CourseRepository;
import com.rubypaper.domain.Enrol;
import com.rubypaper.domain.EnrolRepository;
import com.rubypaper.domain.Student;
import com.rubypaper.domain.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private CourseRepository courseRepo;
	
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

	@Override
	public void studentInsert(Student student) {
		studentRepo.save(student);
	}

	@Override
	public void enrolInsert(Enrol enrol) {
		enrolRepo.save(enrol);
	}

	@Override
	public List<Course> getCourseList() {
		return (List<Course>) courseRepo.findAll();
	}

	@Override
	public Student getStudent(String sno) {
		return studentRepo.findBySno(sno);
	}

	@Override
	public Course getCourse(String cno) {
		return courseRepo.findByCno(cno);
	}

	@Override
	public void deleteStudent(String sno) {
		studentRepo.deleteById(sno);
	}

	@Override
	public Enrol findBySnoAndCno(String sno, String cno) {
		return enrolRepo.findBySnoAndCno(sno, cno);
	}

	@Override
	public void deleteT(Enrol enrol) {
		enrolRepo.delete(enrol);
	}

	@Override
	public void deleteCno(List<Enrol> enrol) {
		enrolRepo.deleteAll(enrol);
	}

	@Override
	public void deleteQuery() {
		enrolRepo.deleteQuery();
	}

	@Override
	public Enrol findByCnoAndSno(String cno, String sno) {
		return enrolRepo.findByCnoAndSno(cno, sno);
	}

	@Override
	public List<Enrol> findByCno(String cno) {
		return enrolRepo.findByCno(cno);
	}
	
	@Override
	public List<Enrol> findBySno(String sno) {
		return enrolRepo.findBySno(sno);
	}


}
