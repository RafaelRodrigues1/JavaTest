package com.example.testecd2.services.calculofreteedataentrega.classes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.example.testecd2.services.calculofreteedataentrega.interfaces.CalculoFreteEDataEntrega;

public class CepsDDDsIguais extends SuperCalculoFreteEDataEntrega 
							implements CalculoFreteEDataEntrega {

	public CepsDDDsIguais(double peso) {
		super(peso);
	}

	@Override
	public double calculaFrete() {
		return super.peso * (1 - calculaDesconto());
	}

	@Override
	public double calculaDesconto() {
		return 0.5;
	}

	@Override
	public LocalDate calculaDataEntrega() {
		return LocalDate.now().plus(1, ChronoUnit.DAYS);
	}
}
