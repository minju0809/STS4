package com.rubypaper.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
  SecurityConfig() {
    System.out.println("==>SecurityConfig");
  }

  @Autowired
  SecurityUserDetailsService securityUserDetail;

  @SuppressWarnings("removal")
  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http.authorizeHttpRequests(authorize -> authorize
        // .requestMatchers("/guest/**", "/class/**").authenticated() // 로그인(인증)한 사용자 허용
        .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
        .requestMatchers("/manager/**").hasAnyAuthority("ROLE_MANAGER", "ROLE_ADMIN")
        .requestMatchers("/member/**", "/class/**").hasAnyAuthority("ROLE_MEMBER", "ROLE_MANAGER", "ROLE_ADMIN") // 멤버
        .anyRequest().permitAll());

    http.csrf(csrf -> csrf.disable()); // 기본으로 나오는 시큐리티 로그인 화면 비활성화
    http.formLogin(login -> login.loginPage("/login.do").defaultSuccessUrl("/loginSuccess.do", true)); // 로그인, 성공 시 이동
    http.exceptionHandling(handling -> handling.accessDeniedPage("/accessDenied.do")); // 권한이 없는 페이지 선택 시 이동
    http.logout(logout -> logout.invalidateHttpSession(true).logoutSuccessUrl("/logout.do")); // 로그아웃, 시 이동
    http.userDetailsService(securityUserDetail);
    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }
}
