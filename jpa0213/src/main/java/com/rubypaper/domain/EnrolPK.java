package com.rubypaper.domain;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Data
@EqualsAndHashCode
public class EnrolPK implements Serializable {
	
	private String cno;
	private String sno;

}
