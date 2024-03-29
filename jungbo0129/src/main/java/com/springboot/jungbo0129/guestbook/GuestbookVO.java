package com.springboot.jungbo0129.guestbook;

import lombok.Data;

@Data
public class GuestbookVO {
  private int idx;
  private String name;
  private String memo;
  private String today;

  private String ch1;
  private String ch2;

  private int rownum;
  private int rnum;

  private int start;
  private int pageSize;
  private int end;
}
