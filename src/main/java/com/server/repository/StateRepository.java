package com.server.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.entity.StateEntity;

@Repository
public interface StateRepository extends JpaRepository<StateEntity, Long> {

	public StateEntity				findById(Long id);
	public List<StateEntity>		findBySiglaLike(String sigla);
	public List<StateEntity>		findByNomeLike(String nome);
	public Page<StateEntity> 		findById(Long id, Pageable pageable);
	public Page<StateEntity> 		findBySiglaLike(String siglaLike, Pageable pageable);
	public Page<StateEntity> 		findByNomeLike(String nomeLike, Pageable pageable);

}
