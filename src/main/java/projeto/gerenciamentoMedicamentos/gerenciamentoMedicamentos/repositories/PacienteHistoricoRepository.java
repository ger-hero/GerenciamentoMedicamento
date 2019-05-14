package projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
		String remedio;
		String dia;
		String manha;
		String tarde;
		String noite;

		try {
			while (resultSet.next()) {
				id = resultSet.getInt("id");
				idPaciente = resultSet.getInt("idpaciente");
				remedio = resultSet.getString("remedio");
				dia = resultSet.getString("dia");
				manha = resultSet.getString("manha");
				tarde = resultSet.getString("tarde");
				noite = resultSet.getString("noite");

				pacienteHistorico.add(new PacienteHistorico(id, idPaciente, remedio, dia, manha, tarde, noite));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pacienteHistorico;
	}
	
	public void insereRegistroMedicamento(int id, String remedio, String turno) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
		LocalDate date = LocalDate.now();
		int res = 0;
		String dia = date.format(formatter);
		
		if(verificaRegistroDia(DadosMemoria.getPacienteHistorico(), dia)) {
			if(turno.equals("manha")) {
				res = executaUpdate(turno, remedio, dia);
			}
			else if (turno.equals("tarde")) {
				res = executaUpdate(turno, remedio, dia);
			} 
			else if (turno.equals("noite")) {
				res = executaUpdate(turno, remedio, dia);
			}
		} 
//		else {
//			if(turno.equals("manha")) {
//				String sql = "INSERT INTO pacientehistorico (idpaciente, dia, manha, tarde, noite) VALUES ('" +id+ "', '" +dia+ "', '"+remedio+ "', '', '')";
//				res = Conexao.getInstance().executeUpdate(sql);
//			}
//			else if(turno.equals("tarde")) {
//				String sql = "INSERT INTO pacientehistorico (idpaciente, dia, manha, tarde, noite) VALUES ('" +id+ "', '" +dia+ "', '', '" +remedio+ "', '')";
//				res = Conexao.getInstance().executeUpdate(sql);
//			} 
//			else if (turno.equals("noite")) {	
//				String sql = "INSERT INTO pacientehistorico (idpaciente, dia, manha, tarde, noite) VALUES ('" +id+ "', '" +dia+ "', '', '', '" +remedio+ "')";
//				res = Conexao.getInstance().executeUpdate(sql);
//			}	
//		}	
		printResposta(res);
	}
	
	private boolean verificaRegistroDia(List<PacienteHistorico> pacienteHistorico, String dia) {
		for(PacienteHistorico p : pacienteHistorico) {
			if(p.getDia().equals(dia)) 
				return true;		
		}
		return false;
	}
	
	private void printResposta(int resposta) {
		if (resposta >= 1)
			System.out.println("Inserção realizada!");
		else
			System.err.println("Inserção NÃO realizada!");
	}

	private int executaUpdate(String turno, String remedio, String dia) {
		// UPDATE pacientehistorico SET noite = 'novoRemedio' WHERE dia = '14-05-2019'
		String sql = "UPDATE pacientehistorico SET "+ turno +" = '" + remedio + "' WHERE dia = '" + dia + "'";
		return Conexao.getInstance().executeUpdate(sql);
	} 
	
	private ResultSet retornaPacienteHistorico() {
		String sql = "SELECT * FROM pacientehistorico ORDER BY id";
		return Conexao.getInstance().executeQuery(sql);
	}
}
