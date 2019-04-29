package projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model;

public class PacienteHistorico {
	private int id;
	private int idPacienteDoenca;
	private String horario;

	public PacienteHistorico(int id, int idPacienteDoenca, String horario) {
		super();
		this.id = id;
		this.idPacienteDoenca = idPacienteDoenca;
		this.horario = horario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPacienteDoenca() {
		return idPacienteDoenca;
	}

	public void setIdPacienteDoenca(int idPacienteDoenca) {
		this.idPacienteDoenca = idPacienteDoenca;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

}
