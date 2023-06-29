package com.br.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.br.model.ClienteModel;

import com.br.repository.ClienteRepository;

@Service
public class EstudoService {

	@Autowired
	ClienteService service;

	@Autowired
	ClienteRepository repository;

	public List<String> buscarNomes() {
		List<String> nomes = new ArrayList<>();
		Iterable<ClienteModel> clientes = service.findClientes();
		for (ClienteModel cliente : clientes) {
			nomes.add("nome: " + cliente.getNome() + " cpf: " + cliente.getCpf());
		}
		return nomes;
	}

	public List<String> buscaCpf() {
		List<String> cpf = new ArrayList<>();
		List<ClienteModel> clientes = service.findClientes();
		for (ClienteModel client : clientes) {
			cpf.add(client.getCpf());
		}
		return cpf;
	}

	public List<String> registrosNumerados() {
		List<String> registro = new ArrayList<>();
		List<ClienteModel> cliente = service.findClientes();
		
			for (int i = 0; i < cliente.size(); i++) {
				registro.add(i +  " - " + cliente.get(i).getNome() + " " + cliente.get(i).getSobrenome());
			}
			
		return registro;
	}
}
