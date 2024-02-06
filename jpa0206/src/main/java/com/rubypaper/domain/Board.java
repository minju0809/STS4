package com.rubypaper.domain;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name = "T0206",
uniqueConstraints= {@UniqueConstraint(columnNames= {"SEQ", "WRITER"})})
public class Board { // 189p
	@Id // PK
	@GeneratedValue // 자동증가
	private Long seq;
	@Column(length=20)
	private String title;
	@Column(nullable=false)
	private String writer; 
	private int age;
	// pay decimal(15, 2) default 0.00 설정 // precision: 전체자릿수, scale: 소수점 자릿수
	@Column(insertable=false, precision=12, scale=2, columnDefinition="decimal(15,2) default 0.00")
	private BigDecimal pay;
	@Column(unique=true)
	private String content;
	// default 값을 사용하려면 insertable=false, updatable=false 필수
	// 값을 직접 넣으려면 true 혹은 제거
//	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable=false, updatable=false, columnDefinition="Date default sysdate")
//	@Column(name = "CREATE_DATE")
	private Date createDate;
	@Column(insertable=false, updatable=true, columnDefinition="number default 1")
	private Long cnt;
	
	@Transient // 엔티티 클래스 내의 특정 변수를 영속 필드에서 제외할 때 사용
	private String ch1;
	@Transient
	private String ch2;
	
//	@PrePersist
//    protected void onCreate() {
//        createDate = new Date();
//    }
	
	public Long getSeq() {
		return seq;
	}
	public void setSeq(Long seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public BigDecimal getPay() {
		return pay;
	}
	public void setPay(BigDecimal pay) {
		this.pay = pay;
	}
	public Long getCnt() {
		return cnt;
	}
	public void setCnt(Long cnt) {
		this.cnt = cnt;
	}
	public String getCh1() {
		return ch1;
	}
	public void setCh1(String ch1) {
		this.ch1 = ch1;
	}
	public String getCh2() {
		return ch2;
	}
	public void setCh2(String ch2) {
		this.ch2 = ch2;
	}
	@Override
	public String toString() {
		return "Board [seq=" + seq + ", title=" + title + ", writer=" + writer + ", age=" + age + ", pay=" + pay
				+ ", content=" + content + ", createDate=" + createDate + ", cnt=" + cnt + ", ch1=" + ch1 + ", ch2="
				+ ch2 + "]";
	}

	
}
