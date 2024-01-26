package com.rubypaper.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

  @Autowired
  private LoginDao dao;

  @Override
  public List<LoginVO> getUserList(LoginVO vo) {
    return dao.getUserList(vo);
  }

  @Override
  public LoginVO getUser(LoginVO vo) {
    return dao.getUser(vo);
  }

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

  @Override
  public void updateAll(LoginVO vo) {
    dao.updateAll(vo);
  }

}
