package com.br.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.br.model.ClienteModel;

public interface ClienteRepository extends PagingAndSortingRepository<ClienteModel, Long> {

	public List<ClienteModel> findByNome(@Param("nome") String nome);

	public List<ClienteModel> findBySobrenome(@Param("sobrenome") String saborenome);

	public List<ClienteModel> findByCpf(@Param("cpf") String cpf);

	public List<ClienteModel> findByNomeAndSobrenome(String nome, String sobrenome);
}
