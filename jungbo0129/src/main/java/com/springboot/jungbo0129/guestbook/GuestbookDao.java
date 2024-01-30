package com.springboot.jungbo0129.guestbook;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GuestbookDao {
  List<GuestbookVO> guestbookList(GuestbookVO vo);

  int guestbookCount(GuestbookVO vo);

  void guestbookAdd(GuestbookVO vo);
}
