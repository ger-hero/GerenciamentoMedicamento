public class Paciente {
	//Atributos
	private String nome;
	private int idade;
	private String RG;
	private int telefone;
	private boolean agressivo;
	
	//Construtores
	public Paciente(String nome, int idade, String RG, int telefone, boolean agressivo) {
		this.nome = nome;
		this.idade = idade;
		this.RG = RG;
		this.telefone = telefone;
		this.agressivo = agressivo;
	}
	
	//Metodos
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRG() {
		return RG;
	}
	public void setRG(String rG) {
		RG = rG;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public boolean getAgressivo() {
		return agressivo;
	}
	public void setAgressividade(boolean agressivo) {
		this.agressivo = agressivo;
	}
}
