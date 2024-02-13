package com.rubypaper.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.ToString;

@Entity
@IdClass(EnrolPK.class)
@ToString(exclude={"student", "course"})
public class Enrol {
	@Id
	private String sno;
	@Id
	private String cno;
	private String grade;
	private String mscore;
	private String fscore;
	
	@ManyToOne
	@JoinColumn(name="sno", nullable=false)
	private Student student;
	
	@ManyToOne
	@JoinColumn(name="cno", nullable=false)
	private Course course;
	
	
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
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getMscore() {
		return mscore;
	}
	public void setMscore(String mscore) {
		this.mscore = mscore;
	}
	public String getFscore() {
		return fscore;
	}
	public void setFscore(String fscore) {
		this.fscore = fscore;
	}
	
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	@Override
	public String toString() {
		return "Enrol [sno=" + sno + ", cno=" + cno + ", grade=" + grade + ", mscore=" + mscore + ", fscore=" + fscore
				+ "]";
	}
	
	
}
