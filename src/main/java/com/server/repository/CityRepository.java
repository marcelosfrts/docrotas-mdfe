package com.server.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.entity.CityEntity;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {
	
	public CityEntity				findById(Long id);
	public List<CityEntity>			findByNomeLike(String nome);
	public List<CityEntity>			findByStateEntitySiglaLike(String siglaUfLike);
	public Page<CityEntity>			findById(Long id, Pageable pageable);
	public Page<CityEntity>			findByNomeLike(String nome, Pageable pageable);
	public Page<CityEntity> 		findByStateEntitySiglaLike(String siglaUfLike, Pageable pageable);
	
}
