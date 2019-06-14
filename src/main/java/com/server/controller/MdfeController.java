package com.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.entity.MdfeEntity;
import com.server.repository.MdfeRepository;

@RestController
public class MdfeController {

	@Autowired
	private MdfeRepository mdfeRepository;
	
	@GetMapping(value="/mdfes")
	public List<MdfeEntity> search() {
		return mdfeRepository.findAll();
	}

}
