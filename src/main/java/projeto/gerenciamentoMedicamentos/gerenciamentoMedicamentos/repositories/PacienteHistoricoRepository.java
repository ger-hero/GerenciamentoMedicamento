package projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.Conexao;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.DadosMemoria;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model.PacienteHistorico;

public class PacienteHistoricoRepository {
	
	public List<PacienteHistorico> getListPacienteHistorico() {
		List<PacienteHistorico> pacienteHistorico = new ArrayList<PacienteHistorico>();
		ResultSet resultSet;
		resultSet = this.retornaPacienteHistorico();

		int id;
		int idPaciente;
		String nomePaciente;
		String remedio;
		String dia;
		String horarioManha;
		String horarioTarde;
		String horarioNoite;

		try {
			while (resultSet.next()) {
				id = resultSet.getInt("id");
				idPaciente = resultSet.getInt("idpaciente");
				nomePaciente = resultSet.getString("nomePaciente");
				remedio = resultSet.getString("remedio");
				dia = resultSet.getString("dia");
				horarioManha = resultSet.getString("manha");
				horarioTarde = resultSet.getString("tarde");
				horarioNoite = resultSet.getString("noite");

				pacienteHistorico.add(
						new PacienteHistorico(id, idPaciente,  nomePaciente, remedio, dia, horarioManha, horarioTarde, horarioNoite));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pacienteHistorico;
	}

	public void insereRegistroMedicamento(int id, String remedio, String turno) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date = LocalDate.now();
		String dia = date.format(formatter);

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Date hora = Calendar.getInstance().getTime();
		String horaFormatada = sdf.format(hora);

		int res = 0;

		if (!verificaSeExiste(id, remedio, dia)) {
			res = primeiraInsercao(id, remedio, dia, turno, horaFormatada);
		} else {
			res = executaUpdate(dia, remedio, turno, horaFormatada);
		}
		printResposta(res);
	}

	private boolean verificaSeExiste(int id, String remedio, String dia) {
		for (PacienteHistorico p : DadosMemoria.getPacienteHistorico()) {
			if (p.getIdPaciente() == id) {
				if(p.getDia().equals(dia)) {
					if (p.getRemedio().equals(remedio)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private int primeiraInsercao(int id, String remedio, String dia, String turno, String horaFormatada) {
		int res = 0;
		if (turno.equals("manha")) {
			String sql = "INSERT INTO pacientehistorico (idpaciente, remedio, dia, manha, tarde, noite) VALUES ('" + id+ "', '" + remedio + "', '" + dia + "', '" + horaFormatada + "', '-', '-')";
			res = Conexao.getInstance().executeUpdate(sql);
		} else if (turno.equals("tarde")) {
			String sql = "INSERT INTO pacientehistorico (idpaciente, remedio, dia, manha, tarde, noite) VALUES ('" + id+ "', '" + remedio + "', '" + dia + "', '-', '" + horaFormatada + "', '-')";
			res = Conexao.getInstance().executeUpdate(sql);
		} else if (turno.equals("noite")) {
			String sql = "INSERT INTO pacientehistorico (idpaciente, remedio, dia, manha, tarde, noite) VALUES ('" + id+ "', '" + remedio + "', '" + dia + "', '-', '-', '" + horaFormatada + "')";
			res = Conexao.getInstance().executeUpdate(sql);
		}
		return res;

	}

	private void printResposta(int resposta) {
		if (resposta >= 1)
			System.out.println("Inserção realizada!");
		else
			System.err.println("Inserção NÃO realizada!");
	}

	private int executaUpdate(String dia, String remedio, String turno, String horaFormatada) {
		String sql = "UPDATE pacientehistorico SET " + turno + " = '" + horaFormatada + "' WHERE dia = '" + dia + "'"+ " AND remedio " + " = '" + remedio + "'";
		return Conexao.getInstance().executeUpdate(sql);
	}
	
	private ResultSet retornaPacienteHistorico() {
		String sql = "SELECT pacientehistorico.*, paciente.nome AS nomepaciente FROM pacientehistorico INNER JOIN paciente ON pacientehistorico.idpaciente = paciente.id oRDER BY id";
		return Conexao.getInstance().executeQuery(sql);
	}
}
