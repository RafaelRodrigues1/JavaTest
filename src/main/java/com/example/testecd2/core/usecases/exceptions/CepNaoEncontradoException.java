package com.example.testecd2.core.usecases.exceptions;

public class CepNaoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CepNaoEncontradoException(String msg) {
		super(msg);
	}
}
