package projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.Conexao;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model.PacienteDoenca;

public class PacienteDoencaRepository {

	public List<PacienteDoenca> getListPacienteDoenca() {
		List<PacienteDoenca> pacienteDoencas = new ArrayList<PacienteDoenca>();
		ResultSet resultSet = null;
		resultSet = this.retornaPacienteDoencas();

		int id;
		int idPaciente;
		int idDoenca;

		try {
			while (resultSet.next()) {
				id = resultSet.getInt("id");
				idPaciente = resultSet.getInt("idpaciente");
				idDoenca = resultSet.getInt("iddoenca");

				pacienteDoencas.add(new PacienteDoenca(id, idPaciente, idDoenca));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pacienteDoencas;
	}

	public ResultSet retornaPacienteDoencas() {
		String sql = "SELECT * FROM pacientedoenca";
		Conexao con = new Conexao();
		ResultSet consulta = null;
		consulta = con.executeQuery(sql);
		return consulta;
	}

}
