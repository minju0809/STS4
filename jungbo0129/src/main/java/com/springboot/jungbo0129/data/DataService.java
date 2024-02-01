package com.springboot.jungbo0129.data;

import java.util.List;

public interface DataService {
  void dataDeleteAll();

  void dataDelete(DataVO vo);

  void dataInsert(DataVO vo);

  List<DataVO> dataList(DataVO vo);

  DataVO data(DataVO vo);
}
