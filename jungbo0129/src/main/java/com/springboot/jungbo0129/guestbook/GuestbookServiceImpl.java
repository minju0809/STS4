package com.springboot.jungbo0129.guestbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestbookServiceImpl implements GuestbookService {
  @Autowired
  private GuestbookDao dao;

  @Override
  public List<GuestbookVO> guestbookList(GuestbookVO vo) {

    return dao.guestbookList(vo);
  }

  @Override
  public void guestbookAdd(GuestbookVO vo) {
    dao.guestbookAdd(vo);
  }

}
