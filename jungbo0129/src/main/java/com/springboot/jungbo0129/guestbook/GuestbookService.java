package com.springboot.jungbo0129.guestbook;

import java.util.List;

public interface GuestbookService {
  List<GuestbookVO> guestbookList(GuestbookVO vo);

  void guestbookAdd(GuestbookVO vo);
}
