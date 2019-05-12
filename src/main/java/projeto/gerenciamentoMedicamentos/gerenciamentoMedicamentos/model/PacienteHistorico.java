package projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model;

public class PacienteHistorico {
	private int id;
	private int idPaciente;
	private String data;
	private String manha;
	private String tarde;
	private String noite;

	public PacienteHistorico(int id, int idPaciente, String data, String manha, String tarde, String noite) {
		super();
		this.id = id;
		this.idPaciente = idPaciente;
		this.data = data;
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

	public String getData() {
		return data;
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
