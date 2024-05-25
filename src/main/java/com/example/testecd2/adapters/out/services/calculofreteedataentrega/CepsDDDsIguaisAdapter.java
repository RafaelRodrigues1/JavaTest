package com.example.testecd2.adapters.out.services.calculofreteedataentrega;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import com.example.testecd2.core.usecases.interfaces.CalculoPort;

public class CepsDDDsIguaisAdapter implements CalculoPort {

	@Override
	public double calculaFrete(Double peso) {
		return peso * (1 - calculaDesconto());
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
