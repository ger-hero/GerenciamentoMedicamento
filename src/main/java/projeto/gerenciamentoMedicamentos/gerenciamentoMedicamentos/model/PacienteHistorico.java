package projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model;

public class PacienteHistorico {
	private int id;
	private int idPaciente;
	private String remedio;
	private String dia;
	private String horarioManha;
	private String horarioTarde;
	private String horarioNoite;

	public PacienteHistorico(int id, int idPaciente, String remedio, String dia, String horarioManha, String horarioTarde, String horarioNoite) {
		super();
		this.id = id;
		this.idPaciente = idPaciente;
		this.remedio = remedio;
		this.dia = dia;
		this.horarioManha = horarioManha;
		this.horarioTarde = horarioTarde;
		this.horarioNoite = horarioNoite;
	}

	public int getId() {
		return id;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public String getRemedio() {
		return remedio;
	}

	public String getDia() {
		return dia;
	}

	public String getHorarioManha() {
		return horarioManha;
	}

	public String getHorarioTarde() {
		return horarioTarde;
	}

	public String getHorarioNoite() {
		return horarioNoite;
	}

}
