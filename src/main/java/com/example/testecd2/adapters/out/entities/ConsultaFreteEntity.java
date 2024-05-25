package com.example.testecd2.adapters.out.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "consultas_frete")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaFreteEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nomeDestinatario;
	
	@Column(nullable = false)
	private String cepOrigem;
	
	@Column(nullable = false)
	private String cepDestino;
	
	@Column(nullable = false)
	private double vlTotalFrete;
	
	@Column(nullable = false)
	private double peso;
	
	@Column(nullable = false)
	private LocalDate dataPrevistaEntrega;
	
	@Column(nullable = false)
	private LocalDate dataConsulta;
}
