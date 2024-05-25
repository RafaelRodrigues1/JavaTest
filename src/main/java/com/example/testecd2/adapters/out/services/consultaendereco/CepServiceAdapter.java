package com.example.testecd2.adapters.out.services.consultaendereco;

import com.example.testecd2.core.usecases.interfaces.ConsultaEnderecoPort;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.testecd2.core.models.Endereco;

@FeignClient(name = "consultacepviacep", url = "https://viacep.com.br/")
public interface CepServiceAdapter extends ConsultaEnderecoPort {

	@RequestMapping(method = RequestMethod.GET, path = "/ws/{cep}/json")
	Endereco getEndereco(@PathVariable String cep);
}
