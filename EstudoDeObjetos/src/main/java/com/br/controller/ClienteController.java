package com.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.model.entity.ClienteModel;
import com.br.model.response.ResponseModel;
import com.br.service.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/Cliente")
@Api(value = "Gerenciamento de clientes.", tags = "Clientes")
public class ClienteController {

	@Autowired
	ClienteService service;

	@ApiOperation(
			value = "Busca Clientes.", 
			notes = "Lista todos clientes cadastrados.")
	@GetMapping("/Clientes")
	private Iterable<ClienteModel> buscaCLientes() {
		return service.findClientes();
	}

	@ApiOperation(
			value = "Busca Cliente pelo id", 
			notes = "Busca cliente baseado no id.")
	@GetMapping(name = "{/id}")
	private ClienteModel buscaClienteId(Long id, @ApiIgnore ClienteModel clienteModel) {
		return service.findClienteId(id, clienteModel);
	}

	@ApiOperation(
			value = "Cadastra Cliente.", 
			notes = "Cadastra um novo cliente")
	@PostMapping(name = "/CadastraCliente")
	private ResponseEntity<?> cadastraCliente(ClienteModel cliente, @ApiIgnore ResponseModel responseModel) {
		return service.createCliente(cliente, responseModel);
	}

	@ApiOperation(
			value = "Atualiza Cliente.", 
			notes = "Atualiza um cliente baseado no id")
	@PutMapping(name = "/AtualizaCliente{/id}")
	private ResponseEntity<?> atualizaCliente(ClienteModel cliente, @ApiIgnore ResponseModel responseModel) {
		return service.updatePorId(cliente, responseModel);
	}

	@ApiOperation(
			value = "Deleta Cliente.", 
			notes = "Deleta um cliente baseado no ID")
	@DeleteMapping(name = "/DeletaCliente{/id}")
	private void deletaCliente(Long id) {
		service.deletaCliente(id);
	}

}
