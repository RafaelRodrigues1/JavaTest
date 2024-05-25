package com.example.testecd2.core.models;

public class Endereco {

	private String cep;
	private String ddd;
	private String uf;

	public Endereco(String cep, String ddd, String uf) {
		this.cep = cep;
		this.ddd = ddd;
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
}
