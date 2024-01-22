package com.rubypaper.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rubypaper.login.LoginServiceImpl;
import com.rubypaper.login.LoginVO;

import jakarta.servlet.http.HttpSession;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

  SecurityUserDetailsService() {
    System.out.println("===> SecurityUserDetailsService");
  }

  @Autowired
  LoginServiceImpl service;

  @Autowired
  HttpSession session;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    LoginVO vo = new LoginVO();
    System.out.println("username: " + username);
    vo.setUsername(username);

    LoginVO user = service.loginOK(vo);
    if (user == null) {
      throw new UsernameNotFoundException(username + " 사용자 없음");
    } else {

      session.setAttribute("session", user);
      return new SecurityUser(user);
    }
  }

}
