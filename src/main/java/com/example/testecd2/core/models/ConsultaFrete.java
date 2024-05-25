package com.example.testecd2.core.models;

import java.io.Serializable;
import java.time.LocalDate;

public class ConsultaFrete implements Serializable {

	private Long id;
	private String nomeDestinatario;
	private String cepOrigem;
	private String cepDestino;
	private double vlTotalFrete;
	private double peso;
	private LocalDate dataPrevistaEntrega;
	private LocalDate dataConsulta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDestinatario() {
		return nomeDestinatario;
	}

	public void setNomeDestinatario(String nomeDestinatario) {
		this.nomeDestinatario = nomeDestinatario;
	}

	public String getCepOrigem() {
		return cepOrigem;
	}

	public void setCepOrigem(String cepOrigem) {
		this.cepOrigem = cepOrigem;
	}

	public String getCepDestino() {
		return cepDestino;
	}

	public void setCepDestino(String cepDestino) {
		this.cepDestino = cepDestino;
	}

	public double getVlTotalFrete() {
		return vlTotalFrete;
	}

	public void setVlTotalFrete(double vlTotalFrete) {
		this.vlTotalFrete = vlTotalFrete;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public LocalDate getDataPrevistaEntrega() {
		return dataPrevistaEntrega;
	}

	public void setDataPrevistaEntrega(LocalDate dataPrevistaEntrega) {
		this.dataPrevistaEntrega = dataPrevistaEntrega;
	}

	public LocalDate getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(LocalDate dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
}
