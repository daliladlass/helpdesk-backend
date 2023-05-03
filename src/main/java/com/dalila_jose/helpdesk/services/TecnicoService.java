package com.dalila_jose.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dalila_jose.helpdesk.domain.Tecnico;
import com.dalila_jose.helpdesk.domain.dtos.TecnicoDTO;
import com.dalila_jose.helpdesk.repositories.TecnicoRepository;
import com.dalila_jose.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;

	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id:" + id));

	}

	public List<Tecnico> findAll() {
		return repository.findAll();
	}

	public Tecnico create(TecnicoDTO objDTO) {
		
		objDTO.setId(null);//apaenas para assegurar que o id vai vir nulo
		Tecnico newObj = new Tecnico(objDTO);
		return repository.save(newObj);			
	}
}
