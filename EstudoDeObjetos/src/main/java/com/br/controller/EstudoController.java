package com.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.model.ResponseModel;
import com.br.repository.ClienteRepository;
import com.br.service.EstudoService;
import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;


@RestController
@RequestMapping("/Estudo")
@Api(value = "Endpoints para estudos", tags = "Estudos")
public class EstudoController {

    @Autowired
    EstudoService serviceEstudo;

    @Autowired
    ClienteRepository repository;

    @RequestMapping("/buscarNomes")
    public ResponseEntity<?> BuscarNome(@ApiIgnore ResponseModel response) {
    	response.setMessage(serviceEstudo.buscarNomes().toString());
    	return ResponseEntity.status(HttpStatus.OK).body(serviceEstudo.buscarNomes());
    }
}

