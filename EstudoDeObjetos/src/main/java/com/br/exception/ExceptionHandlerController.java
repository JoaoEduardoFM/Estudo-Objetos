package com.br.exception;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.br.model.response.ResponseModel;

@RestControllerAdvice
public class ExceptionHandlerController {
    
	/**
	 * @author João	
	 * @apiNote Método que retorna erros do validation
	 */
    @ExceptionHandler(value = { MethodArgumentNotValidException.class})
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
    	ResponseModel response = new ResponseModel();
		List<String> erros = ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage)
				.collect(Collectors.toList());	
		erros.forEach(t -> response.setMessage(erros.toString()));
		erros.addAll(erros);
		return new ResponseEntity<>(erros, HttpStatus.BAD_REQUEST);		
    }
}
