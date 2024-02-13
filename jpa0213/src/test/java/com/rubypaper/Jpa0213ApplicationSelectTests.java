package com.rubypaper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rubypaper.domain.Enrol;
import com.rubypaper.domain.EnrolRepository;

@SpringBootTest
class Jpa0213ApplicationSelectTests {
	
	@Autowired
	private EnrolRepository enrolRepo;
	
	@Test
	void contextLoads() {
		List<Enrol> li = (List<Enrol>) enrolRepo.findAll();
		
		for(Enrol m : li) {
			System.out.println(m.getSno() + ", " + m.getStudent().getSname() + ", "
			+ m.getCourse().getCname() + ", " + m.getMscore() + ", " + m.getFscore());
			System.out.println(m);
		}
		
		Enrol enrol = enrolRepo.findBySnoAndCno("400", "C123");
		System.out.println("==>" + enrol);
		System.out.println("학생정보 ==> " + enrol.getStudent());
		System.out.println("과목정보 ==> " + enrol.getCourse());
	}

}
