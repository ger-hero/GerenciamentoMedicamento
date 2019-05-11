package projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.Conexao;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.DadosMemoria;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model.Doenca;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model.Paciente;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model.PacienteDoenca;

public class PacienteRepository {

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
				idPaciente = resultSet.getInt("id");
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

		for (PacienteDoenca p : DadosMemoria.getPacientedoencas()) {
			if (p.getIdPaciente() == idPaciente) {
				doencas.add(getDoenca(p.getIdDoenca()));
			}
		}
		return doencas;
	}

	public Doenca getDoenca(int idDoenca) {
		List<Doenca> doenca = DadosMemoria.getDoencas().stream().filter((Doenca d) -> d.getId() == idDoenca)
				.collect(Collectors.toList());

		return doenca.get(0);
	}

	public ResultSet retornaPacientes() {
		String sql = "SELECT * FROM paciente ORDER BY id";
		return Conexao.getInstance().executeQuery(sql);
	}
}
