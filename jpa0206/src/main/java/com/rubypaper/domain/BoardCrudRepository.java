package com.rubypaper.domain;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BoardCrudRepository 
	extends CrudRepository<Board, Long> { // <엔티티이름, PK형>
	
	// find + 엔티티이름(생략가능) + By + 변수 이름(필드명)
	List<Board> findByTitle(String ch2);
	List<Board> findByContentContainingOrderBySeqDesc(String ch1);
	List<Board> findByContentContainingOrTitleContainingOrderBySeqDesc(String ch1, String ch2);
	List<Board> findByContentLike(String ch2);
	List<Board> findByAgeBetweenOrderByAgeDesc(int ch1, int ch2);
	
	List<Board> findByPay(BigDecimal ch2);
}
