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

import com.server.entity.CityEntity;
import com.server.repository.CityRepository;

@RestController
public class CityController {
	
	@Autowired
	private CityRepository cityRepository;
	
	@GetMapping(value="/cities")
	public List<CityEntity> search() {
		return cityRepository.findAll();
	}
	
	@PostMapping(value="/city")
	public CityEntity setCity(@RequestBody CityEntity cityEntity) {
		return cityRepository.save(cityEntity);
	}
	
	@GetMapping(value="/pgcity")
	public Page<CityEntity> search(@RequestParam(value="pag", required=true)int pagina,
								   @RequestParam(value="qtd", required=true)int qtd,
								   @RequestParam(value="id", required=false)Long id,
								   @RequestParam(value="nomeLike", required=false)String nomeLike,
								   @RequestParam(value="siglaUfLike", required=false)String siglaUfLike) throws Exception {
		
		Pageable pageable = new PageRequest(pagina, qtd);
		Page<CityEntity> pageCity;
		
		if(id != null) {
			pageCity = cityRepository.findById(id, pageable);
		} else if (nomeLike != null) {
			pageCity = cityRepository.findByNomeLike(nomeLike, pageable);
		} else if (siglaUfLike != null) {
			pageCity = cityRepository.findByStateEntitySiglaLike(siglaUfLike, pageable);
		} else {
			pageCity = cityRepository.findAll(pageable);
		}
		
		return pageCity;
	}
}
