package com.br.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "cliente")
@AllArgsConstructor
@NoArgsConstructor
public class ClienteModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String nome;
	String sobrenome;
	String cpf;
	String data;

}
