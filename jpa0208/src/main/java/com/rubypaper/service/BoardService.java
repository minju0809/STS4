package com.rubypaper.service;

import java.util.List;

import com.rubypaper.domain.Board;

public interface BoardService {
	
	List<Board> boardList(Board vo);
}
