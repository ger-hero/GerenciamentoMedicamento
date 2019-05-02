package projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model;

public class Paciente {
	private int id;
	private String nome;
	private String ala;
	private String foto;

	public Paciente(int id, String nome, String ala, String foto) {
		super();
		this.id = id;
		this.nome = nome;
		this.ala = ala;
		this.foto = foto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAla() {
		return ala;
	}

	public void setAla(String ala) {
		this.ala = ala;
	}

	public String getImagem() {
		return this.foto;
	}
	
	public void setImagem(String imagem) {
		this.foto = imagem;
	}
}
