package com.rubypaper.domain;

import org.springframework.data.repository.CrudRepository;

public interface BoardCrudRepository 
	extends CrudRepository<Board, Long> { // <엔티티이름, PK형>
	
}
