package com.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.server.entity.MenuEntity;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, Long> {
	
	@Query("select u from MenuEntity u where u.visivel > 0 order by u.menuPai, u.ordem")
	public List<MenuEntity> findAllOrderByPaiAndOrder();
}
