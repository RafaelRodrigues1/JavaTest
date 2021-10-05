package com.example.testecd2.services.calculofreteedataentrega.interfaces;

import java.time.LocalDate;

import com.example.testecd2.dto.ConsultaCep;
import com.example.testecd2.services.calculofreteedataentrega.classes.CepsDDDsIguais;
import com.example.testecd2.services.calculofreteedataentrega.classes.CepsEstadosDiferentes;
import com.example.testecd2.services.calculofreteedataentrega.classes.CepsEstadosIguais;

public interface CalculoFreteEDataEntrega {

	double calculaFrete();
	double calculaDesconto();
	LocalDate calculaDataEntrega();
	
	static CalculoFreteEDataEntrega strategy(ConsultaCep consultaCepOrigem, 
			ConsultaCep consultaCepDestino, double peso) {
		if (consultaCepOrigem.getDdd().equals(consultaCepDestino.getDdd())) {
			return new CepsDDDsIguais(peso);
		}
		if (consultaCepOrigem.getUf().equals(consultaCepDestino.getUf())) {
			return new CepsEstadosIguais(peso);
		}else {
			return new CepsEstadosDiferentes(peso);
		}
	}
}
