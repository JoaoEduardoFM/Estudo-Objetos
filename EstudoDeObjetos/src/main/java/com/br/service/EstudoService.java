package com.br.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

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
	
	public Set<ClienteModel> ordenadorOrdemDeInsercao() {
		Set<ClienteModel> ordenador = new LinkedHashSet<>(service.findClientes());
		for (ClienteModel clienteModel : ordenador) {
			clienteModel.getId();
			clienteModel.getCpf();
			clienteModel.getData();
			clienteModel.getNome();
			clienteModel.getSobrenome();
		}
		return ordenador;
	}
	
	public Set<ClienteModel> ordemAleatoria() {
		Set<ClienteModel> ordenador = new HashSet<>(service.findClientes());
		for (ClienteModel clienteModel : ordenador) {
			clienteModel.getId();
			clienteModel.getCpf();
			clienteModel.getData();
			clienteModel.getNome();
			clienteModel.getSobrenome();
		}
		return ordenador;
		
	}
	
	public Set<ClienteModel> ordemNaturalNome(){
		Set<ClienteModel> ordenador = new TreeSet<>(service.findClientes());
		ordenador.addAll(ordenador);
		for (ClienteModel clienteModel : ordenador) {
			clienteModel.getId();
			clienteModel.getCpf();
			clienteModel.getData();
			clienteModel.getNome();
			clienteModel.getSobrenome();
		}		
		return ordenador;
		
	}
	
	public Set<ClienteModel> ordemNaturalSobrenome(){
		Set<ClienteModel> ordenador = new TreeSet<>(new ComparatorSobrenome());
		List<ClienteModel> clientes = service.findClientes();
		ordenador.addAll(clientes);
		for (ClienteModel clienteModel : ordenador) {
			clienteModel.getId();
			clienteModel.getCpf();
			clienteModel.getData();
			clienteModel.getNome();
			clienteModel.getSobrenome();
		}		
		return ordenador;
		
	}
	
	public Map<String, ClienteModel> ordenacaoPorId(){
		List<ClienteModel> cliente = service.findClientes();
		Map<String, ClienteModel> ordenadorId = new TreeMap<>();
			for (int i = 0; i < cliente.size(); i++) {				
				ordenadorId.put(cliente.get(i).getId().toString(), cliente.get(i));
			}
			return ordenadorId;
	}
	
	public Map<Long, ClienteModel> ordenacaoAleatoriaMap(){ // a fazer
		List<ClienteModel> cliente = service.findClientes();
		Map<Long, ClienteModel> ordenadorId = new HashMap<>();
		for (Map.Entry<Long, ClienteModel> clienteModel : ordenadorId.entrySet()) {
			ordenadorId.get(ordenadorId);
		}
		return ordenadorId;
		
	}
	
	class ComparatorSobrenome implements Comparator<ClienteModel>{

	    @Override
	    public int compare(ClienteModel s1, ClienteModel s2) {

	        int sobrenome = s1.getSobrenome().compareTo(s2.getSobrenome());
	        if (sobrenome != 0) return sobrenome;   
	        
	        return s1.getSobrenome().compareTo(s2.getSobrenome());

	}
	}
}
