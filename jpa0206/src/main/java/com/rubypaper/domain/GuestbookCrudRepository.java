package com.rubypaper.domain;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface GuestbookCrudRepository
	extends CrudRepository<Guestbook0207, Long>, QuerydslPredicateExecutor<Guestbook0207> {

//	List<Guestbook0207> OrderByNoDesc(Pageable paging);
//	Page<Guestbook0207> findByNameContaining(String ch1, Pageable paging);
	
//	@Query(value = "SELECT * FROM (SELECT g1_0.*, ROWNUM as rn FROM guestbook0207 g1_0 WHERE g1_0.name LIKE ?1 ESCAPE '\\' ORDER BY g1_0.no DESC) WHERE ROWNUM <= ?2", nativeQuery = true)
//	List<Guestbook0207> findByNameContaining(String ch1, int limit);
	
	// seq, title, age
	@Query("select b from Guestbook0207 b where b.title like %?1% order by b.seq desc")
	List<Guestbook0207> queryAnnotationTest1(String str);
	
	@Query("select b from Guestbook0207 b where b.title like %:strVal% order by b.seq desc")
	List<Guestbook0207> queryAnnotationTest2(@Param("strVal") String str);
	
	@Query("select b.seq, b.title from Guestbook0207 b where b.title like %:strVal% order by b.seq desc")
	List<Object[]> queryAnnotationTest3(@Param("strVal") String str);
	
	@Query(value="select seq, title from T0207 where title like '%'||?1||'%' "
			+ "order by seq desc", nativeQuery=true)
	List<Object[]> queryAnnotationTest4(String str);
	
	@Query(value="select * from T0207 where title like '%'||?1||'%' "
			+ "order by seq desc", nativeQuery=true)
	List<Guestbook0207> queryAnnotationTest5(String str);
}
