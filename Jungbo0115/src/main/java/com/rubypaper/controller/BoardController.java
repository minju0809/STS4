package com.rubypaper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rubypaper.project.board.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	
	BoardController() {
		System.out.println("===> BoardController");
	}
	
	@GetMapping("getBoardList.do")
	String getBoardList(Model model) {
//		service.getBoardList(null);
		return "/board/getBoardList";
	}

	@GetMapping("BoardForm.do")
	String BoardForm() {
		service.insert(null);
		return "BoardForm";
	}
}
