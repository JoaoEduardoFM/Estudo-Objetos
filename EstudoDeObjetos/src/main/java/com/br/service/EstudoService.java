package com.br.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
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
		Set<ClienteModel> comparador = new TreeSet<>(Comparator.comparing(t -> t.getSobrenome()));
		Set<ClienteModel> set = new TreeSet<>(service.findClientes());
		comparador.addAll(set);
		
		return comparador;
		
	}
	
	public Set<ClienteModel> ordenacaoPorId(){
		List<ClienteModel> cliente = service.findClientes();
		Set<ClienteModel> comparador = new TreeSet<>(Comparator.comparing(t -> t.getId()));
		comparador.addAll(cliente);
			return comparador;
	}
	
	public Set<ClienteModel> ordenacaoAleatoriaSet(){
		Set<ClienteModel> ordenador = new TreeSet<>(service.findClientes());
		List<ClienteModel> clientes = service.findClientes();
		ordenador.addAll(clientes);

		for (ClienteModel clienteModel : ordenador) {
			clienteModel.getId();
		}
		return ordenador;
		
	}
	
	public Set<ClienteModel> ordenacaoPorNome() {
		Set<ClienteModel> ordenador1 = new TreeSet<>(service.findClientes());
		Set<ClienteModel> ordenador = new TreeSet<>(Comparator.comparing(t -> t.getNome()));
		ordenador.addAll(ordenador1);
		for (ClienteModel clienteModel : ordenador) {
			clienteModel.getNome();
		}
		return ordenador;
	}
	
	public Double SomaId() {
		Set<ClienteModel> contador = new TreeSet<>();
		Set<ClienteModel> ordenador = new TreeSet<>(service.findClientes());
		contador.addAll(ordenador);
		double soma = contador.stream().mapToDouble(value -> value.getId()).sum();
		return soma;
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
