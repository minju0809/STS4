package com.rubypaper.project.psd;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PsdDao {
	List<PsdVO> getPsdList(PsdVO vo);
	PsdVO getPsd(PsdVO vo);
	
	void insert(PsdVO vo);
	void delete(PsdVO vo);
}
