package com.rubypaper;


import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rubypaper.domain.Board;
import com.rubypaper.domain.BoardCrudRepository;

@SpringBootTest
class Jpa0206ApplicationTests {
	
	@Autowired
	private BoardCrudRepository repository;

	@Test
	void contextLoads() {
		Board board = new Board();

		board.setWriter("영심이");
		board.setTitle("JPA 연습");
		board.setContent("영심이의 JPA 연습");
//		board.setCreateDate(new Date());
		
		repository.save(board);
	}
	
	@AfterEach
	void selectTest() {
		Iterable<Board> li = repository.findAll();
		
		for(Board m : li) {
			System.out.println("board: " + m);
		}
	}

}
