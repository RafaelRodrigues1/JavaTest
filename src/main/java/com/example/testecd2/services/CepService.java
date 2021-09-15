package com.example.testecd2.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.testecd2.dto.ConsultaCep;
import com.example.testecd2.services.exceptions.CepNaoEncontradoException;

@Service
public class CepService {

	public ConsultaCep getConsultaCep(String cep) {
		RestTemplate template = new RestTemplate();
		UriComponents uri = UriComponentsBuilder
									.newInstance()
									.scheme("https")
									.host("viacep.com.br")
									.path("ws/" + cep + "/json/")
									.build();
		try {
			ConsultaCep consultaCep = template.getForEntity(uri.toString(), ConsultaCep.class).getBody();
			if(consultaCep.getUf() == null) {
				throw new Exception();
			}
			return consultaCep;
		}catch(Exception ex) {
			throw new CepNaoEncontradoException("O cep " + cep + " é inválido!");	
		}
	}
}
