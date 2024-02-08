package com.rubypaper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.querydsl.core.BooleanBuilder;
import com.rubypaper.domain.Board;
import com.rubypaper.domain.BoardCrudRepository;
import com.rubypaper.domain.QBoard;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardCrudRepository boardRepo;
	
	@Override
	public List<Board> boardList(Board vo) {
		
		BooleanBuilder builder = new BooleanBuilder();
		
		QBoard qboard = QBoard.board;
		
		if (vo.getCh1() != null) {
			if (vo.getCh1().equals("title")) {
				builder.and(qboard.title.like("%" + vo.getCh2() + "%"));
			} else if (vo.getCh1().equals("content")) {
				builder.and(qboard.content.like("%" + vo.getCh2() + "%"));
			}
		} 
		return (List<Board>) boardRepo.findAll(builder);
	}

}
