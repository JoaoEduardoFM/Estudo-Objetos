package com.br.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.br.model.entity.ClienteModel;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

	public List<ClienteModel> findByNome(@Param("nome") String nome);

	public List<ClienteModel> findBySobrenome(@Param("sobrenome") String saborenome);

	public List<ClienteModel> findByCpf(@Param("cpf") String cpf);

	public List<ClienteModel> findByNomeAndSobrenome(String nome, String sobrenome);
}
