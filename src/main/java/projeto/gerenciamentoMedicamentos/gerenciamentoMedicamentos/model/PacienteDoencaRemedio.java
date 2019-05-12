package projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model;

public class PacienteDoencaRemedio {
	private int idPaciente;
	private String doenca;
	private String remedio;
	private String turno;

	public PacienteDoencaRemedio(int idPaciente, String doenca, String remedio, String turno) {
		super();
		this.idPaciente = idPaciente;
		this.doenca = doenca;
		this.remedio = remedio;
		this.turno = turno;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public String getDoenca() {
		return doenca;
	}

	public String getRemedio() {
		return remedio;
	}

	public String getTurno() {
		return turno;
	}

}
