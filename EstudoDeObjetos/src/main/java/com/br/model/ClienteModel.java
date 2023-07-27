package com.br.model;

import java.util.Objects;

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
public class ClienteModel implements Comparable<ClienteModel> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String nome;
	String sobrenome;
	String cpf;
	String data;

	@Override
	public int compareTo(ClienteModel clienteModel) {
		int nome = clienteModel.getNome().compareTo(clienteModel.getNome());
		if (nome != 0)
			return nome;
		{
			 return this.getNome().compareTo(clienteModel.getNome());
		}
	}
	
	public int compareToSobrenome(ClienteModel clienteModel) {
		int sobrenome = clienteModel.getSobrenome().compareTo(clienteModel.getSobrenome());
		if (sobrenome != 0)
			return sobrenome;
		{
			 return this.getSobrenome().compareTo(clienteModel.getSobrenome());
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, data, id, nome, sobrenome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteModel other = (ClienteModel) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(data, other.data) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(sobrenome, other.sobrenome);
	}
	
	
}


