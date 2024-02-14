package com.rubypaper.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
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
	
	@Transient
	private int scoreSum;
	@Transient
	private double scoreAvg;

	
	@ManyToOne
	@JoinColumn(name="s_sno", nullable=false)
	private Student student;
	
	@ManyToOne
	@JoinColumn(name="c_cno", nullable=false)
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
	

	public int getScoreSum() {
		return scoreSum;
	}
	public void setScoreSum(int scoreSum) {
		this.scoreSum = scoreSum;
	}
	public double getScoreAvg() {
		return scoreAvg;
	}
	public void setScoreAvg(double scoreAvg) {
		this.scoreAvg = scoreAvg;
	}
	
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
		student.getEnrolList().add(this);
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
		course.getEnrolList().add(this);
	}
	
	@Override
	public String toString() {
		return "Enrol [sno=" + sno + ", cno=" + cno + ", grade=" + grade + ", mscore=" + mscore + ", fscore=" + fscore
				+ "]";
	}
	
	
}
