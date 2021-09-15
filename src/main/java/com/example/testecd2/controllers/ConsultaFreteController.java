package com.example.testecd2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.testecd2.dto.ConsultaFreteRequest;
import com.example.testecd2.dto.ConsultaFreteResponse;
import com.example.testecd2.services.ConsultaFreteService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/frete")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ConsultaFreteController {

	private ConsultaFreteService consultaFreteService;
	
	@GetMapping
	public ResponseEntity<ConsultaFreteResponse> consultaFrete(
			@RequestBody ConsultaFreteRequest consultaRequest) {
		ConsultaFreteResponse consultaFreteResponse = consultaFreteService
								.getConsultaFreteResponse(consultaRequest);
		return ResponseEntity.ok().body(consultaFreteResponse);
	}
}
