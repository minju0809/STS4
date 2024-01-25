package com.rubypaper.login;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao {
  List<LoginVO> getUserList(LoginVO vo);

  LoginVO getUser(LoginVO vo);

  LoginVO loginOK(LoginVO vo);

  void insert(LoginVO vo);

  void delete(LoginVO vo);

  void update(LoginVO vo);
}
