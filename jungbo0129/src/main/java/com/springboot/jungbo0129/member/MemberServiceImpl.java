package com.springboot.jungbo0129.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

  @Autowired
  private MemberDao dao;

  @Override
  public List<MemberVO> memberList(MemberVO vo) {
    return dao.memberList(vo);
  }

  @Override
  public int custno() {
    return dao.custno();
  }

  @Override
  public void memberInsert(MemberVO vo) {
    dao.memberInsert(vo);
  }

}
