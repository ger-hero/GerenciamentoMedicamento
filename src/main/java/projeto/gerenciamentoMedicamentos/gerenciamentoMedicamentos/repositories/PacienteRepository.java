package projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.Conexao;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model.Doenca;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model.Paciente;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model.PacienteDoenca;

public class PacienteRepository {

	public Paciente getPaciente(int id) {
		for (Paciente p : getListPacienteDoenca()) {
			if (p.getId() == id)
				return p;
		}
		return null;
	}

	public List<Paciente> getListPacienteDoenca() {
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

				pacientes.add(new Paciente(idPaciente, nomePaciente, ala, foto, getListDoencas(idPaciente)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pacientes;
	}

	public List<Doenca> getListDoencas(int idPaciente) {
		List<Doenca> doencas = new ArrayList<Doenca>();

		PacienteDoencaRepository pacienteDoencaRepository = new PacienteDoencaRepository();

		List<PacienteDoenca> pacientes = new ArrayList<PacienteDoenca>();

		pacientes.addAll(pacienteDoencaRepository.getListPacienteDoenca());

		for (PacienteDoenca p : pacientes) {
			if (p.getIdPaciente() == idPaciente) {
				doencas.add(getDoenca(p.getIdDoenca()));
			}
		}
		return doencas;
	}

	public Doenca getDoenca(int idDoenca) {
		DoencaRepository dr = new DoencaRepository();
		return dr.getDoenca(idDoenca);
	}

	public ResultSet retornaPacientes() {
		String sql = "SELECT * FROM paciente ORDER BY id";
		Conexao con = new Conexao();
		ResultSet consulta = null;
		consulta = con.executeQuery(sql);
		return consulta;
	}
}
