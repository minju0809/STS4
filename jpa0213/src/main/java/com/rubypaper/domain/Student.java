package com.rubypaper.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Transient;

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
	
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
	public List<Enrol> getEnrolList() {
		return enrolList;
	}
	public void setEnrolList(List<Enrol> enrolList) {
		this.enrolList = enrolList;
	}
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", year=" + year + ", dept=" + dept + "]";
	}
	
}
