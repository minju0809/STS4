package com.rubypaper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rubypaper.project.board.BoardService;
import com.rubypaper.project.board.BoardVO;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;

	BoardController() {
		System.out.println("===> BoardController");
	}

	@GetMapping("getBoardList.do")
	String getBoardList(Model model) {
		model.addAttribute("li", service.getBoardList(null));
		return "/board/getBoardList";
	}

	@GetMapping("boardForm.do")
	String boardForm() {
		System.out.println("form");
		return "/board/boardForm";
	}
	
	@GetMapping("boardInsert.do")
	String boardInsert(BoardVO vo) {
		System.out.println("저장하기");
//		service.insert(vo);
		
		return "redirect:getBoardList.do";
	}
}
