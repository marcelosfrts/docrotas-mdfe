package com.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.server.entity.CompanyEntity;
import com.server.repository.CompanyRepository;
import com.server.utils.MethodsUtils;

@RestController
public class CompanyController {

	@Autowired
	private CompanyRepository companyRepository;

	@GetMapping(value="/companys")
	public List<CompanyEntity> search() {
		return companyRepository.findAll();
	}

	@GetMapping(value="/icompanys")
	public String getInputs() throws Exception {
		MethodsUtils methods = new MethodsUtils();
		return methods.mountedCompanySelectedJson(companyRepository.findAll());
	}

	@PostMapping(value="company")
	public CompanyEntity setInput(@RequestBody CompanyEntity company) throws Exception {
		return companyRepository.save(company);
	}
}