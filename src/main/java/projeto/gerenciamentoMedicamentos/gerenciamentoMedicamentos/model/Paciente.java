package projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model;

import java.util.List;

public class Paciente {
	private int id;
	private String nome;
	private String ala;
	private String foto;
	private List<Doenca> doencas;

	public Paciente(int id, String nome, String ala, String foto) {
		super();
		this.id = id;
		this.nome = nome;
		this.ala = ala;
		this.foto = foto;
	}

	public Paciente(int id, String nome, String ala, String foto, List<Doenca> doencas) {
		super();
		this.id = id;
		this.nome = nome;
		this.ala = ala;
		this.foto = foto;
		this.doencas = doencas;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getAla() {
		return ala;
	}

	public String getImagem() {
		return this.foto;
	}

	public List<Doenca> getDoencas() {
		return doencas;
	}

}
