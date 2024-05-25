package com.example.testecd2.adapters.in.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.testecd2.adapters.dto.ConsultaFreteRequest;
import com.example.testecd2.adapters.dto.ConsultaFreteResponse;
import com.example.testecd2.adapters.out.services.ConsultaFreteService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/frete")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ConsultaFreteController {

	private ConsultaFreteService consultaFreteService;
	
	@PostMapping
	public ResponseEntity<ConsultaFreteResponse> consultaFrete(
			@RequestBody ConsultaFreteRequest consultaRequest) {
		ConsultaFreteResponse consultaFreteResponse = consultaFreteService
								.getFrete(consultaRequest);
		return ResponseEntity.ok().body(consultaFreteResponse);
	}
}
