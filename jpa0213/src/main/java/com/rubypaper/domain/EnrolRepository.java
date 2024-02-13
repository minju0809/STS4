package com.rubypaper.domain;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface EnrolRepository extends CrudRepository<Enrol, String>,
	QuerydslPredicateExecutor<Enrol> {
	
	Enrol findBySnoAndCno(String str1, String str2);

}
