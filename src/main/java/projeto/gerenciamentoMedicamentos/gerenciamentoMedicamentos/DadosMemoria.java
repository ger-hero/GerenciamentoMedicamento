package projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model.Doenca;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model.Paciente;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model.PacienteDoenca;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model.PacienteHistorico;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model.Remedio;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.repositories.DoencaRepository;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.repositories.PacienteDoencaRepository;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.repositories.PacienteHistoricoRepository;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.repositories.PacienteRepository;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.repositories.RemedioRepository;

public final class DadosMemoria {
	private static DadosMemoria instance = null;

	private static List<Paciente> pacientes = new ArrayList<Paciente>();
	private static List<Doenca> doencas = new ArrayList<Doenca>();
	private static List<PacienteDoenca> pacienteDoencas = new ArrayList<PacienteDoenca>();
	private static List<Remedio> remedios = new ArrayList<Remedio>();
	private static List<PacienteHistorico> pacienteHistorico = new ArrayList<PacienteHistorico>();

	private DadosMemoria() {
		pacienteDoencas.addAll(new PacienteDoencaRepository().getListPacienteDoenca());
		doencas.addAll(new DoencaRepository().getListDoenca());
		pacientes.addAll(new PacienteRepository().getListPaciente());
		remedios.addAll(new RemedioRepository().getListRemedios());
		pacienteHistorico.addAll(new PacienteHistoricoRepository().getListPacienteHistorico());
	} 

	public static synchronized DadosMemoria getInstance() {
		if (instance == null) {
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
	
	public static Doenca getDoenca(int id) {
		List<Doenca> ld = doencas.stream().filter((Doenca d) -> d.getId() == id).collect(Collectors.toList());
		return ld.get(0);
	}

	public static List<PacienteDoenca> getPacientedoencas() {
		return pacienteDoencas;
	}

	public static List<Remedio> getRemedios() {
		return remedios;
	}
	
	public static Remedio getRemedio(int id) {
		List<Remedio> lr = remedios.stream().filter((Remedio r) -> r.getId() == id).collect(Collectors.toList());
		return lr.get(0);
	}

	public static List<PacienteHistorico> getPacienteHistorico() {
		return pacienteHistorico;
	}
	
	public static void carregaTabelaPacienteHistorico() {
		pacienteHistorico.addAll(new PacienteHistoricoRepository().getListPacienteHistorico());
	}
}
