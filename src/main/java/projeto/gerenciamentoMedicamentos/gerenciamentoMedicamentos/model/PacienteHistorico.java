package projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model;

public class PacienteHistorico {
	private int id;
	private int idPaciente;
	private String remedio;
	private String dia;
	private String manha;
	private String tarde;
	private String noite;

	public PacienteHistorico(int id, int idPaciente, String remedio, String dia, String manha, String tarde, String noite) {
		super();
		this.id = id;
		this.idPaciente = idPaciente;
		this.remedio = remedio;
		this.dia = dia;
		this.manha = manha;
		this.tarde = tarde;
		this.noite = noite;
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

	public String getManha() {
		return manha;
	}

	public String getTarde() {
		return tarde;
	}

	public String getNoite() {
		return noite;
	}
}
