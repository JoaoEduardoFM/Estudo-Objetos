package com.br.util;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.model.ClienteModel;
import com.br.repository.ClienteRepository;
import com.br.service.ClienteService;
 

@Service
public class ValidaCampos {
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	ClienteRepository repository;

	public Boolean validaSeIdExiste(Long id){
		try {
			Optional<ClienteModel> clienteCadastrado = repository.findById(id);
		if( clienteCadastrado != null) {
			return true;
		}
		}catch(Exception e) {
			return false;
		}
		return false;
	}
}
