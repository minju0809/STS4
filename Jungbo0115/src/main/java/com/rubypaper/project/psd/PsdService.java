package com.rubypaper.project.psd;

import java.util.List;

public interface PsdService {
	List<PsdVO> getPsdList(PsdVO vo);
	PsdVO getPsd(PsdVO vo);
	
	void insert(PsdVO vo);
	void delete(PsdVO vo);
}
