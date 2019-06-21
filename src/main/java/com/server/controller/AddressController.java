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

import com.server.entity.AddressEntity;
import com.server.repository.AddressRepository;

@RestController
public class AddressController {

	@Autowired
	private AddressRepository addressRepository;
	
	@GetMapping(value="/adresses")
	public List<AddressEntity> search(@RequestParam(value="cep", required=false)String cep,
									  @RequestParam(value="endereco", required=false)String endereco,
									  @RequestParam(value="id", required=false)Long id) throws Exception {
		if(id != null) {
			return addressRepository.findById(id);
		} else if (cep != null) {
			return addressRepository.findByCepLike(cep + "%");
		} else if (endereco != null) {
			return addressRepository.findByEnderecoLike(endereco + "%");
		} else {
			return addressRepository.findAll();
		}
	}

	@PostMapping(value="address")
	public AddressEntity setAddress(@RequestBody AddressEntity addressEntity) {
		return addressRepository.save(addressEntity);
	}
	
	@GetMapping(value="/pgaddress")
	public Page<AddressEntity> search(@RequestParam(value="pag", required=true)int pagina,
									  @RequestParam(value="qtd", required=true)int qtd,
									  @RequestParam(value="id", required=false)Long id,
									  @RequestParam(value="enderecoLike", required=false)String enderecoLike,
									  @RequestParam(value="cepLike", required=false)String cepLike) throws Exception {

		Pageable pageable = new PageRequest(pagina, qtd);
		Page<AddressEntity> pageAddress;
		
		if(id != null) {
			pageAddress = addressRepository.findById(id, pageable);
		} else if (enderecoLike != null) {
			pageAddress = addressRepository.findByEnderecoLike(enderecoLike, pageable);
		} else if (cepLike != null) {
			pageAddress = addressRepository.findByCepLike(cepLike, pageable);
		} else {
			pageAddress = addressRepository.findAll(pageable);
		}
		
		return pageAddress;
	}
}