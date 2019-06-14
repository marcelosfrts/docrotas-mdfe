package com.server.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.entity.VehicleEntity;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {

	public VehicleEntity		findById(Long id);
	public List<VehicleEntity>  findByPlacaLike(String placa);
	public List<VehicleEntity>  findByTipoRodado(String tipoRodado);
	public List<VehicleEntity>  findByTipoCarroceria(String tipoCarroceria);

	public Page<VehicleEntity>  findById(Long id, Pageable pageable);
	public Page<VehicleEntity>  findByPlacaLike(String placa, Pageable pageable);
	public Page<VehicleEntity>  findByTipoRodado(String tipoRodado, Pageable pageable);
	public Page<VehicleEntity>  findByTipoCarroceria(String tipoCarroceria, Pageable pageable);

}
