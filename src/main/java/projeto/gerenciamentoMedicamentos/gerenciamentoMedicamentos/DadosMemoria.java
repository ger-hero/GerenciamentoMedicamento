package projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos;

import java.util.ArrayList;
import java.util.List;

import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model.Doenca;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model.Paciente;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model.PacienteDoenca;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model.Remedio;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.repositories.DoencaRepository;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.repositories.PacienteDoencaRepository;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.repositories.PacienteRepository;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.repositories.RemedioRepository;

public final class DadosMemoria {
	private static DadosMemoria instance;
	
	private static List<Paciente> pacientes = new ArrayList<Paciente>();
	private static List<Doenca> doencas = new ArrayList<Doenca>();
	private static List<PacienteDoenca> pacienteDoencas = new ArrayList<PacienteDoenca>();
	private static List<Remedio> remedios = new ArrayList<Remedio>();
	
	private DadosMemoria() {
		pacienteDoencas.addAll(new PacienteDoencaRepository().getListPacienteDoenca());
		doencas.addAll(new DoencaRepository().getListDoenca());
		pacientes.addAll(new PacienteRepository().getListPaciente());
		remedios.addAll(new RemedioRepository().getListRemedios());
	}
	
	public static DadosMemoria getInstance() {
		if(instance == null) {
			instance = new DadosMemoria();
		}
		return instance;
	}
	
	public static List<Paciente> getPacientes() {
		return pacientes;
	}

	public static List<Doenca> getDoencas() {
		return doencas;
	}

	public static List<PacienteDoenca> getPacientedoencas() {
		return pacienteDoencas;
	}

	public static List<Remedio> getRemedios() {
		return remedios;
	}
	
}
