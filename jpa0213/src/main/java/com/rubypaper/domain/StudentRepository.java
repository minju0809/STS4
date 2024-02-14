package com.rubypaper.domain;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, String>,
	QuerydslPredicateExecutor<Student> {

	Student findBySno(String sno);
}
