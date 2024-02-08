package com.rubypaper.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import jakarta.transaction.Transactional;

public interface BoardCrudRepository extends CrudRepository<Board, Long>,
	QuerydslPredicateExecutor<Board> {

	@Query("select b from Board b where b.title like %?1% or b.content like %?2%"
			+ "order by b.seq desc")
	List<Board> SelectTest1(String str1, String str2);
	
	@Query("select b from Board b where b.seq < 70 "
			+ "order by b.seq desc")
	List<Board> SelectTest2();
	
	@Transactional
	@Modifying
	@Query("update Board b set b.id = 'member1' "
			+ "where b.seq >= 70")
	void Update();
	
	@Transactional
	@Modifying
	@Query(value="update Board set id = 'member2' "
			+ "where seq < 70", nativeQuery=true)
	void Update2();
	
	@Query(value="insert into Board (seq, title) values (999, '123asf')", nativeQuery=true)
	void Insert();
	
	@Query(value="delete from Board where seq = 999", nativeQuery=true)
	void Delete();
	
}
