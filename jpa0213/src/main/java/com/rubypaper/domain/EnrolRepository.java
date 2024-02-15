package com.rubypaper.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import jakarta.transaction.Transactional;

public interface EnrolRepository extends CrudRepository<Enrol, EnrolPK>,
	QuerydslPredicateExecutor<Enrol> {
	
	Enrol findBySnoAndCno(String str1, String str2);
	Enrol findByCnoAndSno(String str1, String str2);
	List<Enrol> findByCno(String str1);
	
	List<Enrol> findBySno(String sno);
	
	@Transactional
	@Modifying
	@Query(value="delete from enrol where sno='500' and cno ='C312'", nativeQuery=true)
	void deleteQuery();
}
