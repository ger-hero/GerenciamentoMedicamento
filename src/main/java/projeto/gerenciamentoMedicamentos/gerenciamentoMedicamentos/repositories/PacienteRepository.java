package projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.Conexao;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model.Paciente;

public class PacienteRepository {
	
	public PacienteRepository() 
	{
		
	}
	
	public List<Paciente> getPacientes(){
		
		List<Paciente> lp = new ArrayList<Paciente>();
		
		return lp;
	}

	public List<Paciente> buscarPaciente(Paciente paciente) {
		List<Paciente> pacientes = new ArrayList<Paciente>();
		ResultSet resultSet;
		resultSet = this.retornaPacientes();
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
