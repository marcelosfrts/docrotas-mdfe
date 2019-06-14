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

import com.server.entity.NeighborhoodEntity;
import com.server.repository.NeighborhoodRepository;
import com.server.utils.MethodsUtils;

@RestController
public class NeighborhoodController {

	@Autowired
	private NeighborhoodRepository neighborhoodRepository;
	
	@GetMapping(value="/neighborhoods")
	public List<NeighborhoodEntity> search() {
		return neighborhoodRepository.findAll();
	}
	
	@GetMapping(value="/ineighborhoods")
	public String getInputs() throws Exception {
		MethodsUtils methods = new MethodsUtils();
		return methods.mountedNeighborhoodSelectedJson(neighborhoodRepository.findAll());
	}	
	
	@PostMapping(value="/neighborhood")
	public NeighborhoodEntity setNeighborhood(@RequestBody NeighborhoodEntity neighborhoodEntity) {
		return neighborhoodRepository.save(neighborhoodEntity);
	}
	
	@GetMapping(value="/pgneighborhood")
	public Page<NeighborhoodEntity> search(@RequestParam(value="pag", required=true)int pagina,
										   @RequestParam(value="qtd", required=true)int qtd,
										   @RequestParam(value="id", required=false)Long id,
										   @RequestParam(value="nomeLike", required=false)String nomeLike) throws Exception {
	
		Pageable pageable = new PageRequest(pagina, qtd);
		Page<NeighborhoodEntity> pageNeighborhood;
		
		if(id != null) {
			pageNeighborhood = neighborhoodRepository.findById(id, pageable);
		} else if (nomeLike != null) {
			pageNeighborhood = neighborhoodRepository.findByNomeLike(nomeLike, pageable);
		} else {
			pageNeighborhood = neighborhoodRepository.findAll(pageable);
		}
		
		return pageNeighborhood;
	}
}
