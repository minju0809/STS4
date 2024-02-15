package com.rubypaper.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class EnrolPK implements Serializable {
	private String cno;
	private String sno;
	
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	
}
