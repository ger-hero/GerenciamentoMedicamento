package projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model;

public class PacienteDoenca {
	private int id;
	private int idPaciente;
	private int idDoenca;

	public PacienteDoenca(int id, int idPaciente, int idDoenca) {
		super();
		this.id = id;
		this.idPaciente = idPaciente;
		this.idDoenca = idDoenca;
	}

	public int getId() {
		return id;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public int getIdDoenca() {
		return idDoenca;
	}

}
