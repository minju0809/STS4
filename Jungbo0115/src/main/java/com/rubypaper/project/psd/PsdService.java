package com.rubypaper.project.psd;

import java.util.List;

public interface PsdService {
	List<PsdVO> getPsdList(PsdVO vo);
	
	void insert(PsdVO vo);
}
