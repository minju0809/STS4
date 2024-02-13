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
@ToString(exclude="boardList")
public class Member {
	@Id 
	@Column(name="member_id")
	private String id;
	private String password;
	private String name;
	private String role;
	
	// mappedBy 는 연관관계의 주인을 찾는 속성
	// Board 엔티티의 member 필드를 주인으로 설정
	// cascade=CascadeType.ALL 설정 시 Member 수정, 삭제 시 게시판의 회원객체를 통해 게시글 자동 처리
	@OneToMany(mappedBy="member", 
		     fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Board> boardList = new ArrayList<Board>();
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	public List<Board> getBoardList() {
		return boardList;
	}
	public void setBoardList(List<Board> boardList) {
		this.boardList = boardList;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", role=" + role + "]";
	}
	
	
}
