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
public class ConsultaCep implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotEmpty
	private String cep;
	
	@NotEmpty
	@Size(min = 2, max = 2)
	private String ddd;
	
	@NotEmpty
	private String uf;
}
