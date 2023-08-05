package com.br.util;

import com.br.model.entity.ClienteModel;

public class ComparadorCliente implements Comparable<ClienteModel>{

	@Override
	public int compareTo(ClienteModel cliente) {
		int sobrenome = cliente.getSobrenome().compareTo(cliente.getSobrenome());
		if (sobrenome != 0)
			return sobrenome;
		
		int cpf = cliente.getCpf().compareTo(cliente.getCpf());
		if (cpf != 0)
			return cpf;
		
		{
			 return cliente.getData().compareTo(cliente.getData());
		}
	}

	

}
