package com.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.br.model.ResponseModel;
import com.br.repository.ClienteRepository;
import com.br.service.EstudoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;


@RestController
@RequestMapping("/Estudo")
@Api(value = "Endpoints para estudos", tags = "Estudos", description = "teste")
public class EstudoController {

    @Autowired
    EstudoService serviceEstudo;

    @Autowired
    ClienteRepository repository;

    @ApiOperation (
    		value = "Busca nome e cpf cadastrados(Não formatado).",
    		notes = "Retorna registros de nome e cpf cadastrados no banco de dados.")
    @GetMapping("/buscarNomes")
    public ResponseEntity<?> BuscarNome(@ApiIgnore ResponseModel response) {
    	response.setMessage(serviceEstudo.buscarNomes().toString());
    	return ResponseEntity.status(HttpStatus.OK).body(serviceEstudo.buscarNomes());
    }  
    
    @ApiOperation (
    		value = "Busca nome cadastrado.",
    		notes = "Retorna registros de nome cadastrado no banco de dados.")
    @GetMapping("/buscarNomes/{nome}")
    public ResponseEntity<?> BuscarPorNome(@ApiIgnore ResponseModel response, String nome) {
    	return ResponseEntity.status(HttpStatus.OK).body(repository.findByNome(nome));
    }  
    
    @ApiOperation(
    		value = "Busca sobrenome cadastrado.",
    		notes = "Retorna registros de sobrenome cadastrado no banco de dados.")
    @GetMapping("/buscaSobrenome/{sobrenome}")
    public ResponseEntity<?> BuscaPorSobrenome(String sobrenome){
    	return ResponseEntity.status(HttpStatus.OK).body(repository.findBySobrenome(sobrenome));
    }
    
    @ApiOperation(
    		value = "Busca cpf cadastrado.",
    		notes = "Retorna registro de cpf cadastrado no banco de dados.")
    @GetMapping("/bscaCpf/{cpf}")
    public ResponseEntity<?> BuscaPorCpf(String cpf){
    	return ResponseEntity.status(HttpStatus.OK).body(repository.findByCpf(cpf));
    }
    
    @ApiOperation(
    		value = "Busca nome e sobrenome cadastrado",
    		notes = "Retorna registro de nome e sobrenome cadastrado no banco de dados.")
    public ResponseEntity<?> BuscaPorNomeSobrenome(String nome, String sobrenome){
    	return ResponseEntity.status(HttpStatus.OK).body(repository.findByNomeAndSobrenome(nome, sobrenome));
    }
    
    @ApiOperation(
    		value = "Busca registro cadastrado(Paginados)",
    		notes = "Retorna registros paginados")
    @GetMapping("/buscarNomesPaginados")
    public ResponseEntity<?> BuscarClientesPaginados(@ApiIgnore ResponseModel response, @ApiIgnore Pageable page) {
    	return ResponseEntity.status(HttpStatus.OK).body(repository.findAll(page));
    }   
}

