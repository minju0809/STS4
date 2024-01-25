package com.rubypaper.login;

import java.io.File;

import lombok.Data;

@Data
public class LoginVO {
  private String idx;
  private String username; // 이름 고정
  private String password; // 이름 고정
  private String role; // 이름 고정
  private String name;
  private String grade;
  private String fileStr;
  private File file;
}
