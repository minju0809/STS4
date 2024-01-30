package com.springboot.jungbo0129.guestbook;

import lombok.Data;

@Data
public class GuestbookVO {
  private int idx;
  private String name;
  private String memo;
  private String today;
}
