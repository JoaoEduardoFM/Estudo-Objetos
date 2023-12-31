package com.br.controller;

import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.model.entity.ClienteModel;
import com.br.model.response.ResponseModel;
import com.br.repository.ClienteRepository;
import com.br.service.EstudoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;


@RestController
@RequestMapping("/Estudo")
@Api(value = "Endpoints para estudos", tags = "Estudos", description = "Estudos relacionados ao java.")
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
    
    @GetMapping("/BuscaCpfs")
    @ApiOperation(
    		value = "Busca cpf cadastrado. (Não formatado).",
    		notes= "Retorna registros de cpf cadastrados no banco de dados.")
    public List<String> buscaTotosCpfCadastrado() {
    	return serviceEstudo.buscaCpf();
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
    
    @ApiOperation(
    		value = "Busca registro cadastrado(Numerados)",
    		notes = "Retorna registros no banco de dados numerados.")
    @GetMapping("/buscarRegistroNumerado")
    public ResponseEntity<?> BuscarClientesNumerados(@ApiIgnore ResponseModel response, @ApiIgnore ClienteModel clienteModel) {
    	return ResponseEntity.status(HttpStatus.OK).body(serviceEstudo.registrosNumerados());
    } 
    
    @GetMapping("/OrdemDeInsercao")
    @ApiOperation(
    		value = "Odenacao Set. (Ordem de inserção).",
    		notes= "Ordenação Set. Não permite Id repetido e não contem indices.")
    public Set<ClienteModel> OrdemDeInsercao() {
    	return serviceEstudo.ordenadorOrdemDeInsercao();
    }
    
    @GetMapping("/OrdemAleatoria")
    @ApiOperation(
    		value = "Odenacao Set. (Ordem Aleatoria).",
    		notes= "Ordenação Set. Não permite Id repetido e não contem indices.")
    public Set<ClienteModel> OrdemAleatoria() {
    	return serviceEstudo.ordemAleatoria();
    }
    
    @GetMapping("/OrdemNaturalPorNome")
    @ApiOperation(
    		value = "Odenacao Set. (Ordem Natural nomes).",
    		notes= "Ordenação Set. Não permite Id repetido e não contem indices.")
    public Set<ClienteModel> OrdemNaturalNome() {
    	return serviceEstudo.ordemNaturalNome();
    }
    
    @GetMapping("/OrdemNaturalPorSobrenome")
    @ApiOperation(
    		value = "Odenacao Set. (Ordem Natural sobrenome).",
    		notes= "Ordenação Set. Não permite Id repetido e não contem indices.")
    public Set<ClienteModel> OrdemNaturalSobrenome() {
    	return serviceEstudo.ordemNaturalSobrenome();
    }
    
    @GetMapping("/OrdenacaoPorSetId")
    @ApiOperation(
    		value = "Odenacao Set. (Por Id).",
    		notes= "Ordenação Set.")
    public Set<ClienteModel> OdenacaoPorIdSet() {
    	return serviceEstudo.ordenacaoPorId();
    }
    
    @GetMapping("/OrdenacaoMapAleatoria")
    @ApiOperation(
    		value = "Odenacao Set. (Ordem Aleatoria).",
    		notes= "Ordenação Set.")
    public Set<ClienteModel> OrdenacaaMapAleatoria() {
    	return serviceEstudo.ordenacaoAleatoriaSet();
    }
    
    @GetMapping("/OrdenacaoSetPorNome")
    @ApiOperation(
    		value = "Odenacao Set. (Por Nome).",
    		notes= "Ordenação Set.")
    public Set<ClienteModel> OrdenacaaMapNome() {
    	return serviceEstudo.ordenacaoPorNome();
    }
    
    @GetMapping("/MediaId")
    @ApiOperation(
    		value = "Média id. (Media dos ids cadastrados).",
    		notes= "Média id.")
    public OptionalDouble MediaID() {
    	return serviceEstudo.mediaId();
    }
    
    @GetMapping("/SomaId")
    @ApiOperation(
    		value = "Soma id. (Soma dos ids cadastrados).",
    		notes= "Somador id.")
    public Double SomarID() {
    	return serviceEstudo.SomaId();
    }
    
    
    
}


