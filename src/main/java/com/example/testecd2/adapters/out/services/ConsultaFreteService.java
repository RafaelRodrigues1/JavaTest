package com.example.testecd2.adapters.out.services;

import com.example.testecd2.adapters.out.services.calculofreteedataentrega.CepsDDDsIguaisAdapter;
import com.example.testecd2.adapters.out.services.calculofreteedataentrega.CepsEstadosDiferentesAdapter;
import com.example.testecd2.adapters.out.services.calculofreteedataentrega.CepsEstadosIguaisAdapter;
import com.example.testecd2.core.models.ConsultaFrete;
import com.example.testecd2.core.models.Endereco;
import com.example.testecd2.core.usecases.ConsultaEndereco;
import com.example.testecd2.core.usecases.SalvarConsultaFrete;
import com.example.testecd2.core.usecases.interfaces.CalculoPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testecd2.adapters.dto.ConsultaFreteRequest;
import com.example.testecd2.adapters.dto.ConsultaFreteResponse;
import com.example.testecd2.adapters.out.mappers.ConsultaFreteMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ConsultaFreteService {

	private final ConsultaFreteMapper consultaFreteMapper = ConsultaFreteMapper.INSTANCE;
	private SalvarConsultaFrete salvarConsultaFrete;
	private ConsultaEndereco consultaEndereco;
	
	public ConsultaFreteResponse getFrete(ConsultaFreteRequest consultaRequest) {
		Endereco enderecoOrigem = consultaEndereco.execute(consultaRequest.getCepOrigem());
		Endereco enderecoDestino = consultaEndereco.execute(consultaRequest.getCepDestino());

		ConsultaFrete consultaFrete = ConsultaFreteMapper.INSTANCE.toModel(consultaRequest);
		salvarConsultaFrete.setCalculo(strategy(enderecoOrigem, enderecoDestino));
		salvarConsultaFrete.execute(consultaFrete);
		return consultaFreteMapper.toDTO(consultaFrete);
	}

	private CalculoPort strategy(Endereco consultaCepOrigem, Endereco consultaCepDestino) {
		if (consultaCepOrigem.getDdd().equals(consultaCepDestino.getDdd())) {
			return new CepsDDDsIguaisAdapter();
		}
		if (consultaCepOrigem.getUf().equals(consultaCepDestino.getUf())) {
			return new CepsEstadosIguaisAdapter();
		}else {
			return new CepsEstadosDiferentesAdapter();
		}
	}
}
