package com.springboot.jungbo0129.money;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoneyServiceImpl implements MoneyService {

  @Autowired
  private MoneyDao dao;

  @Override
  public List<MoneyVO> moneyList(MoneyVO vo) {
    return dao.moneyList(vo);
  }

}
