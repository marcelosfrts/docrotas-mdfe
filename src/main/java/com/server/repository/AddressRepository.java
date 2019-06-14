package com.server.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.entity.AddressEntity;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

	public List<AddressEntity>	findById(Long id);
	public List<AddressEntity>	findByEnderecoLike(String endereco);
	public List<AddressEntity>	findByCepLike(String cep);
	public Page<AddressEntity>	findById(Long id, Pageable pageable);
	public Page<AddressEntity>	findByEnderecoLike(String endereco, Pageable pageable);
	public Page<AddressEntity>	findByCepLike(String cep, Pageable pageable);	
}
