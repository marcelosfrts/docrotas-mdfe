package com.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.entity.MdfeEntity;

@Repository
public interface MdfeRepository extends JpaRepository<MdfeEntity, Long> {

}
