package com.rubypaper.board;

import lombok.Data;

@Data
public class BoardVo {
  private	int seq;
  private	String title;
  private	String writer;
  private	String content;
  private	String regdate;
  private	int cnt;
}
