package com.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
