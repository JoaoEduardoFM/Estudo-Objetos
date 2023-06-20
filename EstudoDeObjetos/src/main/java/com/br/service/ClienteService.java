package com.br.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.model.ClienteModel;
import com.br.repository.ClienteRepository;

@Service
public class ClienteService {	

	@Autowired
	ClienteRepository repository;

	public Iterable<ClienteModel> findClientes() {
		return repository.findAll();
	}

	public ClienteModel findClienteId(Long id, ClienteModel clienteModel) {

		ClienteModel buscar = repository.findById(id).orElseThrow(() -> new RuntimeException());
		return buscar;

	}

	public ClienteModel createCliente(ClienteModel cliente) {
		return repository.save(cliente);
	}

	public void deletaCliente(Long id) {
		repository.deleteById(id);
	}

	public ClienteModel updatePorId(ClienteModel cliente) {
		return repository.save(cliente);
	}
}
