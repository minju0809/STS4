package com.rubypaper;

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

	@Test // id=#{username}
	void testDelete() {
		LoginVO vo = new LoginVO();
		vo.setIdx("183");

		service.delete(vo);
		System.out.println("=====> Test delete");
	}

	// @Test // id=#{username}
	// void testUpdate() {
	// LoginVO vo = new LoginVO();
	// vo.setUsername("guest2");
	// vo.setPassword(encoder.encode("guest123"));

	// service.update(vo);
	// System.out.println("=====> Test update");
	// }

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
