package projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.DadosMemoria;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model.Paciente;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model.PacienteDoenca;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model.PacienteDoencaRemedio;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model.PacienteHistorico;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.repositories.PacienteHistoricoRepository;

@Controller
@RestController
public class PacienteController {

	@RequestMapping("/getPaciente")
	public List<Paciente> buscarPaciente() {
		return DadosMemoria.getPacientes();
	}

	@ResponseBody
	@RequestMapping(value = "/getUmPaciente/{id}")
	public Paciente buscarPacient(@PathVariable(value = "id") int id) {
		List<Paciente> aux = DadosMemoria.getPacientes().stream().filter((Paciente p) -> p.getId() == id)
				.collect(Collectors.toList());

		return aux.get(0);
	}

	@ResponseBody
	@RequestMapping(value = "/getRegitroHistorico/{id}")
	public List<PacienteHistorico> getRegistro(@PathVariable(value = "id") int id) {
		List<PacienteHistorico> aux = DadosMemoria.getPacienteHistorico().stream()
				.filter((PacienteHistorico p) -> p.getIdPaciente() == id).collect(Collectors.toList());

		return aux;
	}

	@ResponseBody
	@RequestMapping(value = "/getMedicamentos/{id}")
	public List<PacienteDoencaRemedio> getMedicamentos(@PathVariable(value = "id") int id) {
		List<PacienteDoencaRemedio> pacienteDoencaRemedios = new ArrayList<PacienteDoencaRemedio>();
		for (PacienteDoenca p : DadosMemoria.getPacientedoencas()) {
			if (p.getIdPaciente() == id) {
				int idRemdio = DadosMemoria.getDoenca(p.getIdDoenca()).getIdRemedio();
				if (DadosMemoria.getRemedio(idRemdio).isManha()) {
					if (consulta("manha", DadosMemoria.getRemedio(idRemdio).getNome())) {
						pacienteDoencaRemedios.add(new PacienteDoencaRemedio(p.getIdPaciente(),
								DadosMemoria.getDoenca(p.getIdDoenca()).getNome(),
								DadosMemoria.getRemedio(idRemdio).getNome(), "manha"));
					}

				}
				if (DadosMemoria.getRemedio(idRemdio).isTarde()) {
					if (consulta("tarde", DadosMemoria.getRemedio(idRemdio).getNome())) {
						pacienteDoencaRemedios.add(new PacienteDoencaRemedio(p.getIdPaciente(),
								DadosMemoria.getDoenca(p.getIdDoenca()).getNome(),
								DadosMemoria.getRemedio(idRemdio).getNome(), "tarde"));
					}

				}
				if (DadosMemoria.getRemedio(idRemdio).isNoite()) {
					if (consulta("noite", DadosMemoria.getRemedio(idRemdio).getNome())) {
						pacienteDoencaRemedios.add(new PacienteDoencaRemedio(p.getIdPaciente(),
								DadosMemoria.getDoenca(p.getIdDoenca()).getNome(),
								DadosMemoria.getRemedio(idRemdio).getNome(), "noite"));
					}
				}
			}
		}
		return getListTurno(pacienteDoencaRemedios);
	}
	
	private List<PacienteDoencaRemedio> getListTurno(List<PacienteDoencaRemedio> pacienteDoencaRemedios){
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Brazil/East"));
		int hora = calendar.get(Calendar.HOUR_OF_DAY);

		if (hora >= 6 && hora <= 12) {
			return pacienteDoencaRemedios.stream().filter((PacienteDoencaRemedio p) -> p.getTurno().equals("manha"))
					.collect(Collectors.toList());
		} else if (hora > 12 && hora <= 18) {
			return pacienteDoencaRemedios.stream().filter((PacienteDoencaRemedio p) -> p.getTurno().equals("tarde"))
					.collect(Collectors.toList());
		} else if (hora > 18 && hora <= 24) {
			return pacienteDoencaRemedios.stream().filter((PacienteDoencaRemedio p) -> p.getTurno().equals("noite"))
					.collect(Collectors.toList());
		}
		return null;
	}

	private boolean consulta(String turno, String remedio) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date = LocalDate.now();
		String dia = date.format(formatter);

		if (turno.equals("manha")) {
			for (PacienteHistorico p : DadosMemoria.getPacienteHistorico()) {
				if (p.getRemedio().equals(remedio) && p.getDia().equals(dia) && p.getManha().equals(remedio))
					return true;
			}
		} else if (turno.equals("tarde")) {
			for (PacienteHistorico p : DadosMemoria.getPacienteHistorico()) {
				if (p.getRemedio().equals(remedio) && p.getDia().equals(dia) && p.getTarde().equals(remedio))
					return true;
			}
		} else if (turno.equals("noite")) {
			for (PacienteHistorico p : DadosMemoria.getPacienteHistorico()) {
				if (p.getRemedio().equals(remedio) && p.getDia().equals(dia) && p.getNoite().equals(remedio))
					return true;
			}
		}

		return false;
	}

	@ResponseBody
	@RequestMapping(value = "/insertRegistro/{id}/{remedio}/{turno}")
	public int insereRegistro(@PathVariable(value = "id") int id, @PathVariable(value = "remedio") String remedio, @PathVariable(value = "turno") String turno) {
		new PacienteHistoricoRepository().insereRegistroMedicamento(id, remedio, turno);
		DadosMemoria.carregaTabelaPacienteHistorico();
		return 1;
	}

}
