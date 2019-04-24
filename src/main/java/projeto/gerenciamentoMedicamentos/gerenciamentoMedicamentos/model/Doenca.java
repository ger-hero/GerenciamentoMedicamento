package projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model;

public class Doenca {

	private int id;
	private String doenca;
	private String exemplo;
	private boolean agressivo;
	private int idRemedio;

	public Doenca(int id, String doenca, String exemplo, boolean agressivo, int idRemedio) {
		super();
		this.id = id;
		this.doenca = doenca;
		this.exemplo = exemplo;
		this.agressivo = agressivo;
		this.idRemedio = idRemedio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDoenca() {
		return doenca;
	}

	public void setDoenca(String doenca) {
		this.doenca = doenca;
	}

	public String getExemplo() {
		return exemplo;
	}

	public void setExemplo(String exemplo) {
		this.exemplo = exemplo;
	}

	public boolean isAgressivo() {
		return agressivo;
	}

	public void setAgressivo(boolean agressivo) {
		this.agressivo = agressivo;
	}

	public int getIdRemedio() {
		return idRemedio;
	}

	public void setIdRemedio(int idRemedio) {
		this.idRemedio = idRemedio;
	}

}
