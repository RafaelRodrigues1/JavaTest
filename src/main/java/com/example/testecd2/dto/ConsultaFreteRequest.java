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
public class ConsultaFreteRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotEmpty
	private Double peso;
	
	@NotEmpty
	@Size(min = 8, max = 8)
	private String cepOrigem;
	
	@NotEmpty
	@Size(min = 8, max = 8)
	private String cepDestino;
	
	@NotEmpty
	private String nomeDestinatario;
}
