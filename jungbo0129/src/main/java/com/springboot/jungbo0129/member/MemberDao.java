package com.springboot.jungbo0129.member;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {
  List<MemberVO> memberList(MemberVO vo);

  int custno();

  void memberInsert(MemberVO vo);
}
