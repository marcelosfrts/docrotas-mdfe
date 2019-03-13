package com.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.server.entity.UserEntity;
import com.server.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(value="/users")
	public Page<UserEntity> pesquisar(@RequestParam(value="pag", required=true)int pagina,
									  @RequestParam(value="qtd", required=true)int qtd,
									  @RequestParam(value="userid", required=false)Long userId,
									  @RequestParam(value="idcompany", required=false)Long idCompany,
									  @RequestParam(value="active", required=false)Boolean active,
									  @RequestParam(value="userlike", required=false)String userLike) throws Exception {
		
		Pageable pageable = new PageRequest(pagina, qtd);
		Page<UserEntity> pageUser;
		
		if(userId != null) {
			pageUser = userRepository.findById(userId, pageable);			
		} else if (idCompany != null && active == null) {
			pageUser = userRepository.findByIdCompany(idCompany, pageable);
		} else if (idCompany != null && active != null) {
			pageUser = userRepository.findByActiveAndIdCompany(active, idCompany, pageable);
		} else if (active != null) {
			pageUser = userRepository.findByActive(active, pageable);
		} else if (userLike != null) {
			pageUser = userRepository.findByUserLike(userLike, pageable);
		} else {
			pageUser = userRepository.findAll(pageable);
		}
		
		return pageUser;
	}
	
	
/*	@RequestMapping("/users")
	@ResponseBody
	public String getUsers() {
		return "{\"users\":[{\"name\":\"Lucas\", \"country\":\"Brazil\"}," +
		           "{\"name\":\"Jackie\",\"country\":\"China\"}]}";
	}
*/	
}
