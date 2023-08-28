package com.br.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.model.entity.ClienteModel;
import com.br.repository.ClienteRepository;
import com.br.service.ClienteService;
 

@Service
public class ValidaCampos {
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	ClienteRepository repository;
	
	/**
	 * @apiNote Validar se a data é válida
	 * @param String
	 * @return boolean
	 */
	public boolean isValidDate(String date) {
	      try {
	         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	         LocalDate d = LocalDate.parse(date, formatter);    
	         return true;
	      } catch (DateTimeParseException e) {
	        return false;
	      }   
	   }
	
	/**
	 * @apiNote Valida se o id existe
	 * @param Optional
	 * @return boolean
	 */
	public Boolean validaSeExisteId(Long id) {
		Optional<ClienteModel> buscaPorID = repository.findById(id);
		try {
		if(buscaPorID.get().getId() != null) {
	     return true;
		}
		}catch(Exception e) {
		return false;
		}
		return false;
	}
}
