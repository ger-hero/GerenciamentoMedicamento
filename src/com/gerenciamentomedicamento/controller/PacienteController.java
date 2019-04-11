package com.gerenciamentomedicamento.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.gerenciamentomedicamento.model.Conexao;

public class PacienteController {
	public void carregarPacientes() {
		ResultSet rs = retornaPaciente();
		try {
			while (rs.next()) {
				String nome;
				nome = rs.getString("nome");
				System.out.println(nome);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ResultSet retornaPaciente() {
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
