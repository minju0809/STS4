package com.rubypaper.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(exclude="enrolList")
public class Student {
	@Id 
	@Column(name="s_sno")
	private String sno;
	private String sname;
	private String year;
	private String dept;
	
	@OneToMany(mappedBy="student", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Enrol> enrolList = new ArrayList<Enrol>();

}
