package com.rubypaper.project.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	
	BoardServiceImpl() {
		System.out.println("===> BoardServiceImpl 실행");
	}
	
	@Autowired
	private BoardDao dao;

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return dao.getBoardList(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return dao.getBoard(vo);
	}

	@Override
	public void insert(BoardVO vo) {
		dao.insert(vo);
	}

	@Override
	public void update(BoardVO vo) {
		dao.update(vo);
	}

	@Override
	public void cnt(BoardVO vo) {
		dao.cnt(vo);
	}
	
	@Override
	public void delete(BoardVO vo) {
		dao.delete(vo);
	}

}
