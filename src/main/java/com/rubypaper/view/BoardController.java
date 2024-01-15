package com.rubypaper.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.rubypaper.board.BoardServiceImpl;

@Controller
public class BoardController {
	
	BoardController(){
		System.out.println("===>BoardController ");
	}

	@Autowired
	private BoardServiceImpl  service;
	
	@GetMapping("getBoardList.do")
	String getBoardList( Model  model ) {
		model.addAttribute("li", service.getBoardlist() );
		return "getBoardList";		
	}
}
