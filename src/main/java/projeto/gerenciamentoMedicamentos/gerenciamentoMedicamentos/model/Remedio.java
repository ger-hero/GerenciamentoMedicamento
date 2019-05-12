package projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model;

public class Remedio {
	private int id;
	private String nome;
	private String indicacao;
	private boolean manha;
	private boolean tarde;
	private boolean noite;

	public Remedio(int id, String nome, String indicacao, boolean manha, boolean tarde, boolean noite) {
		super();
		this.id = id;
		this.nome = nome;
		this.indicacao = indicacao;
		this.manha = manha;
		this.tarde = tarde;
		this.noite = noite;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getIndicacao() {
		return indicacao;
	}

	public boolean isManha() {
		return manha;
	}

	public boolean isTarde() {
		return tarde;
	}

	public boolean isNoite() {
		return noite;
	}
}
