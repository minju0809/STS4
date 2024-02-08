package com.rubypaper.domain;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface BoardCrudRepository extends CrudRepository<Board, Long>,
	QuerydslPredicateExecutor<Board> {

}
