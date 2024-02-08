package com.rubypaper.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface MemberCrudRepository extends CrudRepository<Member, String>,
	QuerydslPredicateExecutor<Member> {

//	Optional<Member> findById(String str);
	
//	List<Member> OrderBytIdDesc();
	
//	List<Member> findByRoleContainingOrderByNameAsc(String str);
	
//	List<Member> findByRoleLikeOrderByIdDesc(String str);
}
