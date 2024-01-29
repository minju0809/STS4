package com.springboot.jungbo0129.member;

import java.util.List;

public interface MemberService {
  List<MemberVO> memberList(MemberVO vo);

  MemberVO member(MemberVO vo);

  int custno();

  void memberInsert(MemberVO vo);

  void memberUpdate(MemberVO vo);
}
