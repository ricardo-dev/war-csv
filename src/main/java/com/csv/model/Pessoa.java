package com.csv.model;

import java.util.Date;

public class Pessoa {
	
	private String nome;
	
	private String telefone;
	
	private String email;
	
	private Date data;

	public Pessoa(String nome, String telefone, String email, Date data) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.data = data;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}
