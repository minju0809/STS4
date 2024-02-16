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

@Data
@Entity
@ToString(exclude="enrolList")
public class Course {
	@Id
	@Column(name="c_cno")
	private String cno;
	private String cname;
	private String credit; 
	private String dept;
	private String prname;
	
	@OneToMany(mappedBy="course", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Enrol> enrolList = new ArrayList<Enrol>();
	
}
