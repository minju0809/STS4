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

  @Override
  public void insert(LoginVO vo) {
    dao.insert(vo);
  }

  @Override
  public void delete(LoginVO vo) {
    dao.delete(vo);
  }

  @Override
  public void update(LoginVO vo) {
    dao.update(vo);
  }

}
