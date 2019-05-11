package projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos;

import java.sql.*;

import javax.swing.JOptionPane;

public class Conexao {
	private static Conexao instance = null;

	private static final String URL = "jdbc:postgresql://localhost:5432/gerenciamentoMedicamento";
	private static final String USR = "postgres";
	private static final String PASS = "1234";

	private Conexao() {

	}

	public static synchronized Conexao getInstance() {
		if (instance == null) {
			instance = new Conexao();
		}
		return instance;
	}

	private Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");

			Connection con = DriverManager.getConnection(URL, USR, PASS);
			return con;
		} catch (ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "O driver não foi encontrado");
			return null;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Problemas com a conexão");
			return null;
		}
	}

	public int executeUpdate(String query) {
		try {
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			int res = statement.executeUpdate(query);
			connection.close();
			return res;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Problemas com a conexao");
			return 0;
		}
	}

	public ResultSet executeQuery(String query) {
		try {
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			connection.close();
			return rs;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Problemas com a conexao");
			return null;
		}
	}
}