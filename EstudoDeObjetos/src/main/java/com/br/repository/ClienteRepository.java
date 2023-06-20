package com.br.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.model.ClienteModel;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteModel, Long>{

}
