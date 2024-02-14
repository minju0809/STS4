package com.rubypaper.domain;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String>,
	QuerydslPredicateExecutor<Course> {

	Course findByCno(String cno);
}
