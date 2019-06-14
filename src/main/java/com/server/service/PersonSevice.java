package com.server.service;

import org.mockito.internal.stubbing.answers.ThrowsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.server.entity.AddressEntity;
import com.server.entity.NeighborhoodEntity;
import com.server.entity.PersonEntity;
import com.server.entity.StateEntity;
import com.server.repository.StateRepository;

@Service
public class PersonSevice {

	@Autowired
	private StateRepository stateRepository;
	
	@Transactional
	public void salvarPerson(PersonEntity person) throws Exception {
		try {
			if (person.getCidade().getStateEntity().getId() == null) {
				StateEntity state = new StateEntity();
				state.setNome(person.getCidade().getStateEntity().getNome());
				state.setSigla(person.getCidade().getStateEntity().getSigla());
				state.setIbge(person.getCidade().getStateEntity().getIbge());
				stateRepository.save(state);
			}
		}catch (Exception e) {
			throw new Exception("Falha ao salvar registro.");
		}
	}
}
