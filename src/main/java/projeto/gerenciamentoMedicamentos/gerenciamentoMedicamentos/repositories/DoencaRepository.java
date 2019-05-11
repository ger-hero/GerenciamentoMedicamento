package projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.Conexao;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model.Doenca;

public class DoencaRepository {

	public List<Doenca> getListDoenca() {
		List<Doenca> doencas = new ArrayList<Doenca>();
		ResultSet resultSet;
		resultSet = this.retornaDoencas();

		int id;
		String nome;
		String exemplo;
		boolean agressivo;
		int idremedio;

		try {
			while (resultSet.next()) {
				id = Integer.valueOf(resultSet.getString("id"));
				nome = resultSet.getString("nome");
				exemplo = resultSet.getString("exemplo");
				agressivo = resultSet.getBoolean("agressivo");
				idremedio = Integer.valueOf(resultSet.getString("idremedio"));

				doencas.add(new Doenca(id, nome, exemplo, agressivo, idremedio));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return doencas;
	}

	public ResultSet retornaDoencas() {
		String sql = "SELECT * FROM doenca";
		Conexao con = new Conexao();
		ResultSet consulta = null;
		consulta = con.executeQuery(sql);
		return consulta;
	}
}
