package com.rubypaper.login;

public interface LoginService {
  LoginVO loginOK(LoginVO vo);

  void insert(LoginVO vo);

  void delete(LoginVO vo);

  void update(LoginVO vo);
}
