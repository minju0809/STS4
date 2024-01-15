package com.rubypaper.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardDao {
	List<BoardVo> getBoardlist();
}
