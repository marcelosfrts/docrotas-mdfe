package com.server.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.entity.PersonEntity;

@Repository
public interface PersonRespository extends JpaRepository<PersonEntity, Long> {
	
	public PersonEntity			findById(Long id);
	public List<PersonEntity> 	findByNomeLike(String nome);
	public List<PersonEntity>	findByCpfCnpjLike(String cpfCnpj);
	public Page<PersonEntity>	findById(Long id, Pageable pageable);
	public Page<PersonEntity>	findByNomeLike(String nome, Pageable pageable);
	public Page<PersonEntity>	findByCpfCnpjLike(String cpfCnpj, Pageable pegeable);

}
