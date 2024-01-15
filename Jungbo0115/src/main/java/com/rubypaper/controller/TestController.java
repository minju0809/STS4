package com.rubypaper.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.project.board.BoardVO;

@RestController
public class TestController {
	TestController() {
		System.out.println("===> TestController");
	}
	
	@GetMapping("/getBoardList.json")
	public List<BoardVO> getBoardList() {
		List<BoardVO> boardList = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			BoardVO board = new BoardVO();
			board.setSeq(i);
			board.setTitle("제목" + i);
			board.setWriter("테스터");
			board.setContent(i + "테스트 내용");
			board.setCnt(0);
			boardList.add(board);
		}
		return boardList;
	}
	
	@GetMapping("/getBoard.json")
	public BoardVO getBoard() {
		BoardVO board = new BoardVO();
		board.setSeq(1);
		board.setTitle("테스트 제목");
		board.setWriter("테스터");
		board.setContent("테스트 내용");
		board.setCnt(0);
		return board;
	}
	
}
