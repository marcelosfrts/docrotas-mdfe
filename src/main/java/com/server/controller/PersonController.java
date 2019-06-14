package com.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.server.entity.PersonEntity;
import com.server.repository.PersonRespository;

@RestController
public class PersonController {

	@Autowired
	private PersonRespository personRepository;
	
	@GetMapping(value="/persons")
	public List<PersonEntity> search() {
		return personRepository.findAll();
	}
	
	@PostMapping(value="/person")
	public PersonEntity setPersonEntity(@RequestBody PersonEntity personEntity) {
		return personRepository.save(personEntity);
	}

}
