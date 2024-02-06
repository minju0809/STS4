package com.rubypaper;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
	void findByTitle() {
		List<Board> li = repository.findByTitle("JPA 연습0");
		List<Board> li2 = repository.findByPay(BigDecimal.valueOf(0));
		List<Board> li3 = repository.findByContentLike("%0%");
		List<Board> li4 = repository.findByContentContainingOrderBySeqDesc("내");
		List<Board> li5 = repository.findByContentContainingOrTitleContainingOrderBySeqDesc("1", "제");
		List<Board> li6 = repository.findByAgeBetweenOrderByAgeDesc(11, 13);

		
		for (Board m : li6) {
			System.out.println("board: " + m);
		}
	}
	
//	@Test
//	void contextLoads() {
//		for (int i = 0; i < 5; i++) {
//			Board board = new Board();
//
//			board.setWriter("영심이" + i);
//			board.setTitle("JPA 연습" + i);
//			board.setContent("영심이의 JPA 연습" + i);
//			board.setAge(11 + i);
//
//			repository.save(board);
//		}
//	}

//	@Test
//	void updateTest() {
//		Board board = repository.findById(3L).get();
//		board.setTitle("제목 수정");
//		board.setContent("내용 수정");
//		board.setPay(new BigDecimal(10.50));
//		board.setCnt(9L);
//
//		repository.save(board);
//	}

//	@Test
//	void count() {
//		long count = repository.count();
//
//		System.out.println("전체 레코드 수: " + count);
//	}
	
//	@Test
//	void selectOneTest() {
//		Board m = repository.findById(3L).get();
//
//		System.out.println("board: " + m);
//	}

//	@Test
//	void deleteOneTest() {
//		repository.deleteById(4L);
//	}
	
//	@BeforeEach
//	void deleteTest() {
//		repository.deleteAll();
//	}

	@AfterEach
	void selectAllTest() {
		Iterable<Board> li = repository.findAll(); 

		for (Board m : li) {
			System.out.println("board: " + m);
		}
	}

}
