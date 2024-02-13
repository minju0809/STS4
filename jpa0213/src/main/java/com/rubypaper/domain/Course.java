package com.rubypaper.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.ToString;

@Entity
@ToString(exclude="enrolList")
public class Course {
	@Id
	private String cno;
	private String cname;
	private String credit; 
	private String dept;
	private String prname;
	
	@OneToMany(mappedBy="course", fetch=FetchType.EAGER)
	private List<Enrol> enrolList = new ArrayList<Enrol>();
	
	
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getPrname() {
		return prname;
	}
	public void setPrname(String prname) {
		this.prname = prname;
	}
	
	
	
	public List<Enrol> getEnrolList() {
		return enrolList;
	}
	public void setEnrolList(List<Enrol> enrolList) {
		this.enrolList = enrolList;
	}
	
	@Override
	public String toString() {
		return "Course [cno=" + cno + ", cname=" + cname + ", credit=" + credit + ", dept=" + dept + ", prname="
				+ prname + "]";
	}
	
	
}
