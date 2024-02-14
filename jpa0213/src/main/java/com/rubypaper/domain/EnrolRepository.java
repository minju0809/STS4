package com.rubypaper.domain;

import java.util.List;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface EnrolRepository extends CrudRepository<Enrol, String>,
	QuerydslPredicateExecutor<Enrol> {
	
	Enrol findBySnoAndCno(String str1, String str2);
	
	List<Enrol> findBySno(String sno);

}
