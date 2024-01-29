package com.springboot.jungbo0129.member;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
  private int custno;
  private String custname;
  private String password;
  private String phone;
  private String postcode;
  private String address;
  private String detailAddress;
  private String extraAddress;
  private Date joindate;
  private String grade;
  private String city;
}
