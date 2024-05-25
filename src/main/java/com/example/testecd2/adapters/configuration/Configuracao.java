package com.example.testecd2.adapters.configuration;

import com.example.testecd2.core.usecases.ConsultaEndereco;
import com.example.testecd2.core.usecases.SalvarConsultaFrete;
import com.example.testecd2.core.usecases.interfaces.ConsultaEnderecoPort;
import com.example.testecd2.core.usecases.interfaces.SalvarConsultaFretePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Configuracao {

	@Bean
	public Docket swagger() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.testecd2.adapters.in.controllers"))
				.paths(PathSelectors.any())
				.build();
	}

	@Bean
	public ConsultaEndereco consultaEndereco(ConsultaEnderecoPort consulta) {
		return new ConsultaEndereco(consulta);
	}

	@Bean
	public SalvarConsultaFrete salvarConsultaFrete(SalvarConsultaFretePort salvarConsultaFrete) {
		return new SalvarConsultaFrete(salvarConsultaFrete);
	}
}
