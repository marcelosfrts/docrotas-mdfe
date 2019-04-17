package com.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.entity.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long>{
	public CompanyEntity 		findById(Long id);
}
