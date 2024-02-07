package com.rubypaper;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.querydsl.core.BooleanBuilder;
import com.rubypaper.domain.Guestbook0207;
import com.rubypaper.domain.GuestbookCrudRepository;
import com.rubypaper.domain.QGuestbook0207;

@SpringBootTest
class Jpa0206ApplicationTests {

	@Autowired
	private GuestbookCrudRepository guestbookRepository;

	@Test
	void contextLoads() {
		String ch1 = "title";
		String ch2 = "3";
		
		BooleanBuilder builder = new BooleanBuilder();
		QGuestbook0207 qguestbook = QGuestbook0207.guestbook0207;
	
		if (ch1.equals("title")) {
			builder.and(qguestbook.title.like("%" + ch2 + "%"));
		} else if (ch1.equals("age")) {
			builder.and(qguestbook.age.like("%" + ch2 + "%"));
		}
		
		List<Guestbook0207> li = (List<Guestbook0207>) guestbookRepository.findAll(builder);
		for(Guestbook0207 m : li) {
			System.out.println("==> " + m);
		}
	
	}
	
//	@Test
//	void guestbookInsert() {
//		for(long i = 0; i < 20; i++) {
//			Guestbook0207 guestbook = new Guestbook0207();
//			guestbook.setSeq(i);
//			guestbook.setTitle("JPA 연습" + i);
//			guestbook.setAge("13");
//			
//			guestbookRepository.save(guestbook);
//		}
//	}
	
//	@Test
//	void selectAll( ) {
////		List<Guestbook0207> li = guestbookRepository.queryAnnotationTest1("9");
////		List<Guestbook0207> li = guestbookRepository.queryAnnotationTest2("8");
//		
////		for(Guestbook0207 m : li) {
////			System.out.println("==> " + m);
////		}
//		
////		List<Object[]> li = guestbookRepository.queryAnnotationTest3("7");
////		List<Object[]> li = guestbookRepository.queryAnnotationTest4("6");
//		List<Guestbook0207> li = guestbookRepository.queryAnnotationTest5("5");
//		
//		System.out.println("검색 결과");
////		for(Object[] m : li) {
////			System.out.println("==> " + Arrays.toString(m));
////		}
//		
//		for(Guestbook0207 m : li) {
//			System.out.println("==> " + m);
//		}
//	}
	
	
	
	
//	@Test
//	void findByNameContaining() {
//		int limit = 5; // 페이지당 결과 수
//	    List<Guestbook0207> guestbookList = guestbookRepository.findByNameContaining("name0", limit);
//	    
//	    System.out.println("검색 결과");
//	    for(Guestbook0207 guestbook : guestbookList) {
//	        System.out.println("===> " + guestbook.toString());
//	    }
//	}
	
//	@Test
//	void findByNameContaining() {
//		Pageable paging = PageRequest.of(0, 5);
//		List<Guestbook0207> guestbookList = guestbookRepository.findByNameContaining("0", paging);
		
//		System.out.println("검색 결과");
//		for(Guestbook0207 guestbook : guestbookList) {
//			System.out.println("===> " + guestbook.toString());
//		}
		
//		Pageable paging = PageRequest.of(0, 5, Sort.by("no").descending()); // 페이지 번호, 크기, 정렬 기준을 지정합니다.
//	    Page<Guestbook0207> guestbookPage = guestbookRepository.findByNameContaining("0", paging);
//	    
//	    System.out.println("검색 결과");
//	    for(Guestbook0207 guestbook : guestbookPage.getContent()) {
//	        System.out.println("===> " + guestbook.toString());
//	    }
//	}

//	@Test
//	void findByTitle() {
//		List<Board> li = repository.findByTitle("JPA 연습0");
//		List<Board> li2 = repository.findByPay(BigDecimal.valueOf(0));
//		List<Board> li3 = repository.findByContentLike("%0%");
//		List<Board> li4 = repository.findByContentContainingOrderBySeqDesc("내");
//		List<Board> li5 = repository.findByContentContainingOrTitleContainingOrderBySeqDesc("1", "제");
//		List<Board> li6 = repository.findByAgeBetweenOrderByAgeDesc(11, 13);
//
//		
//		for (Board m : li6) {
//			System.out.println("board: " + m);
//		}
//	}
	
//	@Test
//	void contextLoads() {
//		for (int i = 0; i < 5; i++) {
//			Board board = new Board();
//
//			board.setWriter("영심이" + i);
//			board.setTitle("JPA 연습" + i);
//			board.setContent("영심이의 JPA 연습" + i);
//			board.setAge(11 + i);
//
//			repository.save(board);
//		}
//	}

//	@Test
//	void updateTest() {
//		Board board = repository.findById(3L).get();
//		board.setTitle("제목 수정");
//		board.setContent("내용 수정");
//		board.setPay(new BigDecimal(10.50));
//		board.setCnt(9L);
//
//		repository.save(board);
//	}

//	@Test
//	void count() {
//		long count = repository.count();
//
//		System.out.println("전체 레코드 수: " + count);
//	}
	
//	@Test
//	void selectOneTest() {
//		Board m = repository.findById(3L).get();
//
//		System.out.println("board: " + m);
//	}

//	@Test
//	void deleteOneTest() {
//		repository.deleteById(4L);
//	}
	
//	@BeforeEach
//	void deleteTest() {
//		repository.deleteAll();
//	}

//	@AfterEach
//	void selectAllTest() {
//		Iterable<Board> li = repository.findAll(); 
//
//		for (Board m : li) {
//			System.out.println("board: " + m);
//		}
//	}

}
