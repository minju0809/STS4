package com.springboot.jungbo0129.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {

  @Autowired
  private DataDao dao;

  @Override
  public void dataDeleteAll() {
    dao.dataDeleteAll();
  }

  @Override
  public void dataDelete(DataVO vo) {
    dao.dataDelete(vo);
  }

  @Override
  public void dataInsert(DataVO vo) {
    dao.dataInsert(vo);
  }

  @Override
  public List<DataVO> dataList(DataVO vo) {
    return dao.dataList(vo);
  }

  @Override
  public DataVO data(DataVO vo) {
    return dao.data(vo);
  }

}
