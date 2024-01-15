package com.rubypaper.project.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardDao {
	List<BoardVO> getBoardList(BoardVO vo);
	BoardVO getBoard(BoardVO vo);
	
	void insert(BoardVO vo);
	void update(BoardVO vo);
	void delete(BoardVO vo);
}
