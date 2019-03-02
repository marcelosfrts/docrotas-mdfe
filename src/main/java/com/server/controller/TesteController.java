package com.server.controller;

import org.springframework.web.bind.annotation.RestController;

import com.server.utils.FormatUtils;
import com.server.utils.PatternEnum;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@RestController
@RequestMapping("teste")
public class TesteController {
	
	@GetMapping(path="dados", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getDados() throws ParseException {
		Map<Integer, String> dados = new HashMap<>();
		
		dados.put(1, "Maçã");
		dados.put(2, "Laranja");
		dados.put(3, "Jaboticaba");
		dados.put(4, "Uva");
		dados.put(5, FormatUtils.formatarString("06781793608", PatternEnum.CPF));
		
		return new ResponseEntity<Object>(dados, HttpStatus.OK);
	}
	
}
