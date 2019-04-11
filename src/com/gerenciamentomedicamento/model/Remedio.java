package com.gerenciamentomedicamento.model;


public class Remedio {
	private String nome;
	private int dose;
	private double preco;
	
	public Remedio(String nome, int dose, double preco) {
		this.nome = nome;
		this.dose = dose;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getDose() {
		return dose;
	}

	public void setDose(int dose) {
		this.dose = dose;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
}
