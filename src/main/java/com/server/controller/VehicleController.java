package com.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.server.entity.VehicleEntity;
import com.server.repository.VehicleRepository;

@RestController
public class VehicleController {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@GetMapping(value="/vehicles")
	public List<VehicleEntity> search() {
		return vehicleRepository.findAll();
	}
	
	@PostMapping(value="/vehicle")
	public VehicleEntity setVehicle(@RequestBody VehicleEntity vehicleEntity) {
		return vehicleRepository.save(vehicleEntity);
	}
	
	@GetMapping(value="/pgvehicle")
	public Page<VehicleEntity> search(@RequestParam(value="pag", required=true)int pagina,
			   						  @RequestParam(value="qtd", required=true)int qtd,
			   						  @RequestParam(value="id", required=false)Long id,
									  @RequestParam(value="placa", required=false)String placa,
									  @RequestParam(value="tprodado", required=false)String tipoRodado,
									  @RequestParam(value="tpcarroceria", required=false)String tipoCarroceria) throws Exception {
		
		Pageable pageable = new PageRequest(pagina, qtd);
		Page<VehicleEntity> pageVehicle;
		
		if(id != null) {
			pageVehicle = vehicleRepository.findById(id, pageable);
		} else if (placa != null) {
			pageVehicle = vehicleRepository.findByPlacaLike(placa, pageable);
		} else if (tipoRodado != null) {
			pageVehicle = vehicleRepository.findByTipoRodado(tipoRodado, pageable);
		} else if (tipoCarroceria != null) {
			pageVehicle = vehicleRepository.findByTipoCarroceria(tipoCarroceria, pageable);
		} else {
			pageVehicle = vehicleRepository.findAll(pageable);
		}
		
		return pageVehicle;
	}
}
