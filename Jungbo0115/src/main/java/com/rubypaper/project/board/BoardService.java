package com.rubypaper.project.board;

import java.util.List;

public interface BoardService {
	List<BoardVO> getBoardList(BoardVO vo);
	BoardVO getBoard(BoardVO vo);
	
	void insert(BoardVO vo);
	void update(BoardVO vo);
	void delete(BoardVO vo);
}
