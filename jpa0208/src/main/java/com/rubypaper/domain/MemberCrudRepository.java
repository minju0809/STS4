package com.rubypaper.domain;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface MemberCrudRepository extends CrudRepository<Member, String>,
	QuerydslPredicateExecutor<Member> {

}
