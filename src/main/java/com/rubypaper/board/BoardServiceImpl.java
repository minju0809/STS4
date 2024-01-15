package com.rubypaper.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private   BoardDao  dao;
	
	@Override
	public List<BoardVo> getBoardlist() {
		return dao.getBoardlist();
	}

}
