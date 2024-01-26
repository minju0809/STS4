package com.rubypaper;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.rubypaper.login.LoginService;
import com.rubypaper.login.LoginVO;

@SpringBootTest
class Jungbo0115ApplicationTests {

	@Autowired
	private LoginService service;

	@Autowired
	private PasswordEncoder encoder;

	@AfterEach // 여러 메서드 중 나중에 실행
	void printTest() {
		System.out.println("print test");
	}

	@AfterEach // id=#{username}
	void testGetUserList() {
		System.out.println("=====> Test GetUserList");
		List<LoginVO> li = service.getUserList(null);
		for (LoginVO m : li) {
			System.out.println(m.getIdx() + " : " + m.getUsername() + " : " + m.getPassword());
		}
	}

	// @BeforeEach // 여러 메서드 중 먼저 실행
	// void testDelete() {
	// LoginVO vo = new LoginVO();
	// vo.setIdx("188");

	// service.delete(vo);
	// System.out.println("=====> Test delete");
	// }

	@Test // id=#{username}
	void testUpdate() {
		LoginVO vo = new LoginVO();
		vo.setPassword(encoder.encode("123"));

		service.updateAll(vo);
		System.out.println("=====> Test update" + vo);
	}

	// @Test
	// void testInsert() {
	// LoginVO vo = new LoginVO();
	// vo.setUsername("ppk");
	// vo.setPassword(encoder.encode("ppk123"));
	// vo.setRole("ROLE_MEMBER");
	// vo.setName("너구리");
	// vo.setGrade("회원1");

	// // service.insert(vo);
	// System.out.println("=====> Test insert");
	// }

}
