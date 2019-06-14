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

import com.google.gson.Gson;
import com.server.entity.StateEntity;
import com.server.repository.StateRepository;

@RestController
public class StateController {

	@Autowired
	private StateRepository stateRepository;
	
	@GetMapping(value="/states")
	public List<StateEntity> search() {
		return stateRepository.findAll();
	}
	
	@GetMapping(value="/allstates")
	public String allsearch() {
		return new Gson().toJson(stateRepository.findAllBySelectState());
	}
	
	@PostMapping(value="/state")
	public StateEntity setState(@RequestBody StateEntity stateEntity) {
		return stateRepository.save(stateEntity);
	}
	
	@GetMapping(value="/pgstate")
	public Page<StateEntity> search(@RequestParam(value="pag", required=true)int pagina,
									  @RequestParam(value="qtd", required=true)int qtd,
									  @RequestParam(value="id", required=false)Long id,
									  @RequestParam(value="nomeLike", required=false)String nomeLike,
									  @RequestParam(value="siglaLike", required=false)String siglaLike) throws Exception {
		
		Pageable pageable = new PageRequest(pagina, qtd);
		Page<StateEntity> pageState;
		
		if(id != null) {
			pageState = stateRepository.findById(id, pageable);
		} else if (siglaLike != null) {
			pageState = stateRepository.findBySiglaLike(siglaLike, pageable);
		} else if (nomeLike != null) {
			pageState = stateRepository.findByNomeLike(nomeLike, pageable);
		} else {
			pageState = stateRepository.findAll(pageable);
		}
		
		return pageState;
	}	
	
}
