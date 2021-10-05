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
import com.example.testecd2.services.calculofreteedataentrega.interfaces.CalculoFreteEDataEntrega;
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
		ConsultaFrete consultaFrete = instanciaConsultaFrete(consultaRequest, 
				CalculoFreteEDataEntrega.strategy(consultaCepOrigem, 
						consultaCepDestino, consultaRequest.getPeso()));
		salvarConsultaFrete(consultaFrete);
		return consultaFreteMapper.toDTO(consultaFrete);
	}
	
	private ConsultaFrete instanciaConsultaFrete(ConsultaFreteRequest consultaRequest, 
				CalculoFreteEDataEntrega calculoFreteEDataEntrega) {
		ConsultaFrete consultaFrete;
		try{
			consultaFrete = consultaFreteMapper.toModel(consultaRequest);
			consultaFrete.setVlTotalFrete(calculoFreteEDataEntrega.calculaFrete());
			consultaFrete.setDataConsulta(LocalDate.now());
			consultaFrete.setDataPrevistaEntrega(calculoFreteEDataEntrega.calculaDataEntrega());
		}catch (Exception ex) {
			throw new InstanciaConsultaFreteException("Erro ao instanciar objeto ConsultaFrete");
		}
		return consultaFrete;
	}
	
	private void salvarConsultaFrete(ConsultaFrete consultaFrete) {
		consultaFreteRepository.save(consultaFrete);
	}
}
