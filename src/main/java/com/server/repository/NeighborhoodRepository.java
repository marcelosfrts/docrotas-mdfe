package com.server.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.entity.NeighborhoodEntity;

@Repository
public interface NeighborhoodRepository extends JpaRepository<NeighborhoodEntity, Long> {
	
	public NeighborhoodEntity		findById(Long id);
	public List<NeighborhoodEntity> findByNomeLike(String nome);
	public Page<NeighborhoodEntity> findById(Long id, Pageable pageable);
	public Page<NeighborhoodEntity> findByNomeLike(String nome, Pageable pageable);
	
}
