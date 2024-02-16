package com.rubypaper.domain;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

//@SuppressWarnings("serial")
@Data
@EqualsAndHashCode
public class EnrolPK implements Serializable {
	
	private static final long serialVersionUID = 1L;
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
