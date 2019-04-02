import java.util.Date;

public class Internacao {
	private Doenca[] doencas;
	private Paciente paciente;
	private Date dataInternacao;
	
	public Internacao(Doenca[] doencas, Paciente paciente, Date dataInternacao) {
		super();
		this.doencas = doencas;
		this.paciente = paciente;
		this.dataInternacao = dataInternacao;
	}

	public Doenca[] getDoencas() {
		return doencas;
	}

	public void setDoencas(Doenca[] doencas) {
		this.doencas = doencas;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
}
