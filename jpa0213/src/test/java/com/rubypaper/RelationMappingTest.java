package com.rubypaper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rubypaper.domain.Board;
import com.rubypaper.domain.BoardRepository;
import com.rubypaper.domain.MemberRepository;

@SpringBootTest
public class RelationMappingTest {
	
	@Autowired
	private BoardRepository boardRepo;
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Test
	void contextLoads() {
		Board board = boardRepo.findById(5L).get();
		
		System.out.println("[ " + board.getSeq() + "번 게시글 정보 ]");
		System.out.println("제목: " + board.getTitle());
		System.out.println("내용: " +board.getContent());
		System.out.println("작성자: " + board.getMember().getName());
		System.out.println("작성자 권한: " + board.getMember().getRole());
	}
}
