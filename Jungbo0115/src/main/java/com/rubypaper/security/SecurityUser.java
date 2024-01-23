package com.rubypaper.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.rubypaper.login.LoginVO;

public class SecurityUser extends User {

  private static final long serialVersionUID = 1L;

  public SecurityUser(LoginVO vo) {
    super(vo.getUsername(), vo.getPassword(),
        AuthorityUtils.createAuthorityList(vo.getRole().toString()));
  }
}
