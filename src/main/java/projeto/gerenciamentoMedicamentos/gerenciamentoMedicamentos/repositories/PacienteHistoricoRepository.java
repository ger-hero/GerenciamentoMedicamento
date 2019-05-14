package projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.Conexao;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model.PacienteHistorico;

public class PacienteHistoricoRepository {

	public List<PacienteHistorico> getListPacienteHistorico() {
		List<PacienteHistorico> pacienteHistorico = new ArrayList<PacienteHistorico>();
		ResultSet resultSet;
		resultSet = this.retornaPacienteHistorico();

		int id;
		int idPaciente;
		String data;
		String manha;
		String tarde;
		String noite;

		try {
			while (resultSet.next()) {
				id = resultSet.getInt("id");
				idPaciente = resultSet.getInt("idpaciente");
				data = resultSet.getString("dia");
				manha = resultSet.getString("manha");
				tarde = resultSet.getString("tarde");
				noite = resultSet.getString("noite");

				pacienteHistorico.add(new PacienteHistorico(id, idPaciente, data, manha, tarde, noite));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pacienteHistorico;
	}
	
	public void insereRegistroMedicamento(int id, String remedio, String turno) {
	
		int res = 0;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
		LocalDate date = LocalDate.now();
		
		String dia = date.format(formatter);
		
		if(turno.equals("manha")) {
			String sql = "INSERT INTO pacientehistorico (idpaciente, dia, manha, tarde, noite) VALUES ('" +id+ "', '" +dia+ "', '"+remedio+ "', '', '')";
			res = Conexao.getInstance().executeUpdate(sql);
		}
		else if(turno.equals("tarde")) {
			String sql = "INSERT INTO pacientehistorico (idpaciente, dia, manha, tarde, noite) VALUES ('" +id+ "', '" +dia+ "', '', '" +remedio+ "', '')";
			res = Conexao.getInstance().executeUpdate(sql);
		} 
		else if (turno.equals("noite")) {	
			String sql = "INSERT INTO pacientehistorico (idpaciente, dia, manha, tarde, noite) VALUES ('" +id+ "', '" +dia+ "', '', '', '" +remedio+ "')";
			res = Conexao.getInstance().executeUpdate(sql);
		}
		
		
		if (res >= 1)
			System.out.println("Inserção realizada!");
		else
			System.err.println("Inserção NÃO realizada!");
	}

	public ResultSet retornaPacienteHistorico() {
		String sql = "SELECT * FROM pacientehistorico ORDER BY id";
		return Conexao.getInstance().executeQuery(sql);
	}
}
