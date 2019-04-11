package com.gerenciamentomedicamento.controller;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.gerenciamentomedicamento.model.Paciente;

/**
 * Classe Paciente
 * @author JonasFragoso
 *
 */
public class PacienteController {

/**
 * Pesquisa Paciente sem filtro
 * @return Lista de todos pacientes da tabela PACIENTE
 */
public List<Paciente> buscarPaciente(){
	return buscarPaciente(new Paciente());
}

/**
 * Pesquisa Paciente com filtro
 * @param paciente Filtro
 * @return Retorna lista dos paicentes 
 */
public List<Paciente> buscarPaciente(Paciente paciente) {
	List<Paciente> pacientes = new ArrayList<Paciente>();
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