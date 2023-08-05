package com.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.model.entity.ClienteModel;
import com.br.model.response.ResponseModel;
import com.br.model.response.ResponseModel.messageType;
import com.br.repository.ClienteRepository;
import com.br.util.ValidaCampos;

import springfox.documentation.annotations.ApiIgnore;

@Service
public class ClienteService {
	
	private final String VALIDACAO_DATA = "A data informada é inválida. (dd/MM/yyyy)";
	private final String VALIDACAO_ID = "O id informado não existe.";
	
	ValidaCampos validacoes = new ValidaCampos();

	@Autowired
	ClienteRepository repository;

	public List<ClienteModel> findClientes() {
		return (List<ClienteModel>) repository.findAll();
	}

	public ClienteModel findClienteId(Long id, ClienteModel clienteModel) {

		ClienteModel buscar = repository.findById(id).orElseThrow(() -> new RuntimeException());
		return buscar;

	}

	public ResponseEntity<?> createCliente(ClienteModel cliente, @ApiIgnore ResponseModel response) {
		
		if(!validacoes.isValidDate(cliente.getData().toString())) {
			response.setMessage(VALIDACAO_DATA);
	    	response.setType(messageType.ATENCAO);
	    	return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(cliente));
	}

	public void deletaCliente(Long id) {
		repository.deleteById(id);
	}

	public ResponseEntity<?> updatePorId(ClienteModel cliente, ResponseModel response) {
		if(!validacoes.validaSeExisteId(cliente.getId())) {
			response.setMessage(VALIDACAO_ID);
	    	response.setType(messageType.ATENCAO);
	    	return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		if(!validacoes.isValidDate(cliente.getData().toString())) {
			response.setMessage(VALIDACAO_DATA);
	    	response.setType(messageType.ATENCAO);
	    	return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(cliente));
	}
}
