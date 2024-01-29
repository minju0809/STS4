package com.springboot.jungbo0129.money;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MoneyDao {
  List<MoneyVO> moneyList(MoneyVO vo);
}