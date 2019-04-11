package com.gerenciamentomedicamento.controller;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.gerenciamentomedicamento.model.Conexao;
import com.gerenciamentomedicamento.model.Paciente;

public class PacienteController {
	
public List<Paciente> buscarPaciente(){
	return buscarPaciente(new Paciente());
}
	
public List<Paciente> buscarPaciente(Paciente paciente) {
	List<Paciente> pacientes = new ArrayList();
	ResultSet resultSet;
	resultSet = paciente.retornaPacientes();
	int idPaciente;
	String nomePaciente;
	String ala;
	
	try {
		while(resultSet.next()) {
			idPaciente = Integer.valueOf(resultSet.getString("id"));
			nomePaciente = resultSet.getString("nome");
			ala = resultSet.getString("ala");
			pacientes.add(new Paciente(idPaciente,nomePaciente,ala));		
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return pacientes;
}	
	
	
	
	
}