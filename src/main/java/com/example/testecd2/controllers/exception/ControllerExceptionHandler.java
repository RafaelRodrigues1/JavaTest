package com.example.testecd2.controllers.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.testecd2.services.exceptions.CepNaoEncontradoException;
import com.example.testecd2.services.exceptions.InstanciaConsultaFreteException;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(CepNaoEncontradoException.class)
	public ResponseEntity<Erro> cepNaoEncontrado(CepNaoEncontradoException exception, 
			HttpServletRequest request){
		String erro = "Cep não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		Erro erroObj = new Erro(erro, exception.getMessage(), request.getRequestURI(), 
				status.value(), Instant.now());
		return ResponseEntity.status(status).body(erroObj);
	}
	
	@ExceptionHandler(InstanciaConsultaFreteException.class)
	public ResponseEntity<Erro> erroInstancia(InstanciaConsultaFreteException exception, 
			HttpServletRequest request){
		String erro = "Erro ao instanciar";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		Erro erroObj = new Erro(erro, exception.getMessage(), request.getRequestURI(), 
				status.value(), Instant.now());
		return ResponseEntity.status(status).body(erroObj);
	}
}
