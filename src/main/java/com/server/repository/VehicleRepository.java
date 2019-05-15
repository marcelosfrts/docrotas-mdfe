package com.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.entity.VehicleEntity;

public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {

	public VehicleEntity		findById(Long id);

}
