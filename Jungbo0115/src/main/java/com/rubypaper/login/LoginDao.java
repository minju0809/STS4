package com.rubypaper.login;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao {
  LoginVO loginOK(LoginVO vo);
}
