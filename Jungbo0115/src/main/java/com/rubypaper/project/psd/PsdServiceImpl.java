package com.rubypaper.project.psd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PsdServiceImpl implements PsdService {
	
	@Autowired
	private PsdDao dao;

	@Override
	public List<PsdVO> getPsdList(PsdVO vo) {
		return dao.getPsdList(vo);
	}
	
	@Override
	public PsdVO getPsd(PsdVO vo) {
		return dao.getPsd(vo);
	}

	@Override
	public void insert(PsdVO vo) {
		dao.insert(vo);
	}

	@Override
	public void delete(PsdVO vo) {
		dao.delete(vo);
	}

}
