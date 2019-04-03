package com.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.repository.MenuRepository;
import com.server.utils.MethodsUtils;

@RestController
public class MenuController {
	@Autowired
	private MenuRepository menuRepository;

	@PostMapping(value = "/menu")
	public String carregarMenu() throws Exception {
		MethodsUtils methods = new MethodsUtils();
		return methods.mountedMenuJson(menuRepository.findAll()).toString();
	}
}
