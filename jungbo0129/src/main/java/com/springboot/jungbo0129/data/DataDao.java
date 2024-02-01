package com.springboot.jungbo0129.data;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DataDao {
  void dataDeleteAll();

  void dataDelete(DataVO vo);

  void dataInsert(DataVO vo);

  List<DataVO> dataList(DataVO vo);

  DataVO data(DataVO vo);
}
