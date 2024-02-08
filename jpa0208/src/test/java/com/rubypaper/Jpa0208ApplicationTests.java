package com.rubypaper;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rubypaper.domain.Board;
import com.rubypaper.domain.BoardCrudRepository;
import com.rubypaper.domain.Member;
import com.rubypaper.domain.MemberCrudRepository;

@SpringBootTest
class Jpa0208ApplicationTests {
	
	@Autowired
	MemberCrudRepository memberRepo;
	
	@Autowired
	BoardCrudRepository boardRepo;
	
	@Test
	void IUDLoads() {
		// insert
//		for (int i = 0; i < 1; i++) {
//			Board board = new Board();
//			board.setTitle("제목" + i);
//			board.setContent("내용" + i);
//			board.setCreateDate(new Date());
//			board.setCnt(3L);
//			
//			boardRepo.save(board);
//		}
		
//		// update
//		Board board = boardRepo.findById(1L).get();
//		board.setTitle("제목 수정");
//		board.setContent("내용 수정");
//		
//		boardRepo.save(board);
//		
//		// delete
//		boardRepo.deleteById(1L);
	}
	
	@AfterEach
	void SelectLoads() {
		Board board = boardRepo.findById(2L).get();
		System.out.println("board: " + board);
		
		List<Board> li = (List<Board>)boardRepo.findAll();
		
		for(Board m : li) {
			if(m.getSeq() < 50) {
				System.out.println("===> " + m);
			}
		} 	
	}

	@Test
	void contextLoads() {
//		Member member1 = new Member();
//		member1.setId("member1");
//		member1.setPassword("member123");
//		member1.setName("둘리");
//		member1.setRole("Admin");
//		
//		memberRepo.save(member1);
//		
//		Member member2 = new Member();
//		member2.setId("member2");
//		member2.setPassword("member123");
//		member2.setName("도우너");
//		member2.setRole("User");
//		
//		memberRepo.save(member2);
//		
//		Member member3 = new Member();
//		member3.setId("member3");
//		member3.setPassword("member123");
//		member3.setName("고길동");
//		member3.setRole("User");
//		
//		memberRepo.save(member3);
//		
//		for (int i = 0; i < 100; i++) {
//			Board board = new Board();
//			board.setTitle("제목" + i);
//			board.setContent("내용" + i);
//			board.setCreateDate(new Date());
//			board.setCnt(3L);
//			
//			boardRepo.save(board);
//		}
	}

}
