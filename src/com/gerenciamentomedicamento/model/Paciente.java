package com.gerenciamentomedicamento.model;

import java.sql.ResultSet;

public class Paciente {
	
	/**
	 * ID Paciente
	 */
	private int id;
	
	/**
	 * Nome Paciente
	 */
	private String nome;
	
	/**
	 * ala Paciente
	 */
	private String ala;

	/**
	 * Metodo Construtor inicializando as variáveis
	 * @return Instância do paciente
	 */
	public Paciente(int id, String nome, String ala) {
		super();
		this.id = id;
		this.nome = nome;
		this.ala = ala;
	}

	/**
	 * Método Construtor vazio
	 */
	public Paciente() {

	}

	/**
	 * Get ID
	 * @return valor do campo ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set ID
	 * @param id valor do ID Paciente
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get Nome
	 * @return valor do campo NOME
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Set Nome
	 * @param nome Nome Paciente
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Get Ala
	 * @return retorna valor do campo ALA
	 */
	public String getAla() {
		return ala;
	}

	/**
	 * Set Ala
	 * @param ala valor do campo ALA
	 */
	public void setAla(String ala) {
		this.ala = ala;
	}
	
	/**
	 * Método para buscar os pacientes no banco
	 * @return retorna do banco todos os paicentes
	 */
	public ResultSet retornaPacientes() {
		String sql = "SELECT * FROM paciente";
		Conexao con = new Conexao();
		ResultSet consulta = null;
		consulta = con.executeQuery(sql);
		return consulta;
	}
}
