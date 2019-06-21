package com.server.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	public Page<UserEntity> findById(Long id, Pageable pageable);
	public UserEntity 		findById(Long id);
	
	public Page<UserEntity> findByUserLike(String user, Pageable pageable);
	public List<UserEntity> findByUserLike(String user);
	
	public Page<UserEntity> findByIdCompany(Long idCompany, Pageable pageable);
	public List<UserEntity> findByIdCompany(Long idCompany);
	
	public Page<UserEntity> findByActive(Boolean active, Pageable pageable);
	public List<UserEntity> findByActive(Boolean active);
	
	public Page<UserEntity> findByActiveAndIdCompany(Boolean active, Long idCompany, Pageable pageable);
	public List<UserEntity> findByActiveAndIdCompany(Boolean active, Long idCompany);
	
	public List<UserEntity> findByUser(String user);

}
