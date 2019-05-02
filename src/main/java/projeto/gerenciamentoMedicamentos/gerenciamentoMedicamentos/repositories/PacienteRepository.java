package projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.Conexao;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model.Paciente;

public class PacienteRepository {

	public PacienteRepository() {

	}

	public List<Paciente> getListPaciente() {
		List<Paciente> pacientes = new ArrayList<Paciente>();
		ResultSet resultSet;
		resultSet = this.retornaPacientes();

		int idPaciente;
		String nomePaciente;
		String ala;
		String foto;

		try {
			while (resultSet.next()) {
				idPaciente = Integer.valueOf(resultSet.getString("id"));
				nomePaciente = resultSet.getString("nome");
				ala = resultSet.getString("ala");
				foto = resultSet.getString("foto");
				
				pacientes.add(new Paciente(idPaciente, nomePaciente, ala, foto));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pacientes;

	}

	public ResultSet retornaPacientes() {
		String sql = "SELECT * FROM paciente ORDER BY id";
		Conexao con = new Conexao();
		ResultSet consulta = null;
		consulta = con.executeQuery(sql);
		return consulta;
	}
}
