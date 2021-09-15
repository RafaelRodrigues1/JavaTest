package com.example.testecd2.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testecd2.dto.ConsultaCep;
import com.example.testecd2.dto.ConsultaFreteRequest;
import com.example.testecd2.dto.ConsultaFreteResponse;
import com.example.testecd2.entities.ConsultaFrete;
import com.example.testecd2.mappers.ConsultaFreteMapper;
import com.example.testecd2.repositories.ConsultaFreteRepository;
import com.example.testecd2.services.exceptions.InstanciaConsultaFreteException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ConsultaFreteService {

	private final ConsultaFreteMapper consultaFreteMapper = ConsultaFreteMapper.INSTANCE;
	private ConsultaFreteRepository consultaFreteRepository;	
	private CepService cepService;
	
	public ConsultaFreteResponse getConsultaFreteResponse(ConsultaFreteRequest consultaRequest) {
		ConsultaCep consultaCepOrigem = cepService.getConsultaCep(consultaRequest.getCepOrigem());
		ConsultaCep consultaCepDestino = cepService.getConsultaCep(consultaRequest.getCepDestino());
		double frete = calculaFrete(consultaRequest.getPeso(), consultaCepOrigem, consultaCepDestino);
		LocalDate dataPrevistaEntrega = calculaDataEntrega(consultaCepOrigem, consultaCepDestino);
		ConsultaFrete consultaFrete = instanciaConsultaFrete(consultaRequest, frete, dataPrevistaEntrega);
		salvarConsultaFrete(consultaFrete);
		return consultaFreteMapper.toDTO(consultaFrete);
	}
	
	private double calculaFrete(double peso, ConsultaCep consultaCepOrigem, ConsultaCep consultaCepDestino) {
		double valorFrete = peso;
		return valorFrete * (1 - calculaDesconto(consultaCepOrigem, consultaCepDestino));
	}
	
	private double calculaDesconto(ConsultaCep consultaCepOrigem, ConsultaCep consultaCepDestino) {
		if(consultaCepOrigem.getDdd().equals(consultaCepDestino.getDdd())) {
			return 0.5;
		}
		if(consultaCepOrigem.getUf().equals(consultaCepDestino.getUf())) {
			return 0.75;
		}
		return 0;
	}
	
	private LocalDate calculaDataEntrega(ConsultaCep consultaCepOrigem, ConsultaCep consultaCepDestino) {
		LocalDate dataAtual = LocalDate.now();
		if(consultaCepOrigem.getDdd().equals(consultaCepDestino.getDdd())) {
			return dataAtual.plus(1, ChronoUnit.DAYS);
		}
		if(consultaCepOrigem.getUf().equals(consultaCepDestino.getUf())) {
			return dataAtual.plus(3, ChronoUnit.DAYS);
		}
		return dataAtual.plus(10, ChronoUnit.DAYS);
	}
	
	private ConsultaFrete instanciaConsultaFrete(ConsultaFreteRequest consultaRequest, 
				double vlTotalFrete, LocalDate dataPrevistaEntrega) {
		ConsultaFrete consultaFrete;
		try{
			consultaFrete = consultaFreteMapper.toModel(consultaRequest);
			consultaFrete.setVlTotalFrete(vlTotalFrete);
			consultaFrete.setDataConsulta(LocalDate.now());
			consultaFrete.setDataPrevistaEntrega(dataPrevistaEntrega);
		}catch (Exception ex) {
			throw new InstanciaConsultaFreteException("Erro ao instanciar objeto ConsultaFrete");
		}
		return consultaFrete;
	}
	
	private void salvarConsultaFrete(ConsultaFrete consultaFrete) {
		consultaFreteRepository.save(consultaFrete);
	}
}
