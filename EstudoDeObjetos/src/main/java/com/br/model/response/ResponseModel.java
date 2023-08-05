package com.br.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseModel {

	String message;

	private messageType type;

	public enum messageType {

		ERRO("Erro"),

		CONSISTENCIA("Consistência"),

		ATENCAO("Atenção"),

		INFORMACAO("Informação"),

		SUCESSO("Sucesso");

		private String descricao;

		private messageType(String description) {
			this.descricao = description;
		}

		public String getDescription() {
			return descricao;
		}

		public void setDescription(String description) {
			this.descricao = description;
		}

	}

}