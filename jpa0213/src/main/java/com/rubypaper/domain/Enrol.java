package com.rubypaper.domain;


import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@IdClass(EnrolPK.class)
@ToString(exclude={"student", "course"})
public class Enrol {
	
	@Id
	private String cno;
	@Id
	private String sno;
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

    
	public void setStudent(Student student) {
		this.student = student;
		student.getEnrolList().add(this);
	}

	public void setCourse(Course course) {
		this.course = course;
		course.getEnrolList().add(this);
	}
}
