package com.gerenciamentomedicamento.model;


public class Doenca {
	//Atributos
	private String nome;
	private int severidade;
	private boolean hereditaria;
	private Remedio remedio;
	
	public Doenca(String nome, int severidade, boolean hereditaria, Remedio remedio) {
		this.nome = nome;
		this.severidade = severidade;
		this.hereditaria = hereditaria;
		this.remedio = remedio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getSeveridade() {
		return severidade;
	}

	public void setSeveridade(int severidade) {
		this.severidade = severidade;
	}

	public boolean isHereditaria() {
		return hereditaria;
	}

	public void setHereditaria(boolean hereditaria) {
		this.hereditaria = hereditaria;
	}
}