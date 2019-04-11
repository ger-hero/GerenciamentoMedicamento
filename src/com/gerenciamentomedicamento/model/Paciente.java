package com.gerenciamentomedicamento.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Paciente {
	// Atributos
	private int id;
	private String nome;
	private String ala;

	public Paciente(int id, String nome, String ala) {
		super();
		this.id = id;
		this.nome = nome;
		this.ala = ala;
	}

	public Paciente() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAla() {
		return ala;
	}

	public void setAla(String ala) {
		this.ala = ala;
	}
	
	/*
	 * Método para retornar do banco todos os pacientes cadastrados
	 */
	public ResultSet retornaPacientes() {
		String sql = "SELECT * FROM paciente";
		Conexao con = new Conexao();
		ResultSet consulta = null;
		try {
			consulta = con.executeQuery(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return consulta;
	}
}
