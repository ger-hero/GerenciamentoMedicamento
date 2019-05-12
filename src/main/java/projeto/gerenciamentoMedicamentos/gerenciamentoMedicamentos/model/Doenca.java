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

	public String getNome() {
		return doenca;
	}

	public String getExemplo() {
		return exemplo;
	}

	public boolean isAgressivo() {
		return agressivo;
	}

	public int getIdRemedio() {
		return idRemedio;
	}

}
