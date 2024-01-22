package com.rubypaper.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

  @Autowired
  private LoginDao dao;

  @Override
  public LoginVO loginOK(LoginVO vo) {
    return dao.loginOK(vo);
  }

}
