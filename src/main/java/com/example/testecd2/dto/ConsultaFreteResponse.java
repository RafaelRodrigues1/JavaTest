package com.example.testecd2.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaFreteResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotEmpty
	private double vlTotalFrete;
	
	@NotEmpty
	private String dataPrevistaEntrega;
	
	@NotEmpty
	@Size(min = 8, max = 8)
	private String cepOrigem;
	
	@NotEmpty
	@Size(min = 8, max = 8)
	private String cepDestino;
}
