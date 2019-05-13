package projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
		return DadosMemoria.getInstance().getPacientes();
	}

	@ResponseBody
	@RequestMapping(value = "/getUmPaciente/{id}")
	public Paciente buscarPacient(@PathVariable(value = "id") int id) {
		List<Paciente> aux = DadosMemoria.getInstance().getPacientes().stream().filter((Paciente p) -> p.getId() == id)
				.collect(Collectors.toList());

		return aux.get(0);
	}

	@ResponseBody
	@RequestMapping(value = "/getRegitroHistorico/{id}")
	public List<PacienteHistorico> getRegistro(@PathVariable(value = "id") int id) {
		List<PacienteHistorico> aux = DadosMemoria.getInstance().getPacienteHistorico().stream()
				.filter((PacienteHistorico p) -> p.getIdPaciente() == id).collect(Collectors.toList());

		return aux;
	}

	@ResponseBody
	@RequestMapping(value = "/getMedicamentos/{id}")
	public List<PacienteDoencaRemedio> getMedicamentos(@PathVariable(value = "id") int id) {
		List<PacienteDoencaRemedio> pacienteDoencaRemedios = new ArrayList<PacienteDoencaRemedio>();
		for (PacienteDoenca p : DadosMemoria.getInstance().getPacientedoencas()) {
			if(p.getIdPaciente() == id) {
					int idRemdio = DadosMemoria.getInstance().getDoenca(p.getIdDoenca()).getIdRemedio();
					if(DadosMemoria.getInstance().getRemedio(idRemdio).isManha()) {
						System.out.println("Manha:");
						pacienteDoencaRemedios.add(new PacienteDoencaRemedio(
								p.getIdPaciente(),
								DadosMemoria.getInstance().getDoenca(p.getIdDoenca()).getNome(),
								DadosMemoria.getInstance().getRemedio(idRemdio).getNome(),
								"manha"
								));	
					} if (DadosMemoria.getInstance().getRemedio(idRemdio).isTarde()) {
						pacienteDoencaRemedios.add(new PacienteDoencaRemedio(
								p.getIdPaciente(),
								DadosMemoria.getInstance().getDoenca(p.getIdDoenca()).getNome(),
								DadosMemoria.getInstance().getRemedio(idRemdio).getNome(),
								"tarde"
								));	
					} if (DadosMemoria.getInstance().getRemedio(idRemdio).isNoite()) {
						pacienteDoencaRemedios.add(new PacienteDoencaRemedio(
								p.getIdPaciente(),
								DadosMemoria.getInstance().getDoenca(p.getIdDoenca()).getNome(),
								DadosMemoria.getInstance().getRemedio(idRemdio).getNome(),
								"noite"
								));	
					}	
			}
		}
		
		//Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Brazil/East"));
		//int hora = calendar.get(Calendar.HOUR_OF_DAY); 
		
		int hora = 13;
		
		if(hora >= 6 && hora <= 12) {
			return pacienteDoencaRemedios.stream().filter((PacienteDoencaRemedio p) -> p.getTurno().equals("manha") ).collect(Collectors.toList());
		} else if (hora > 12 && hora <= 18) {
			return pacienteDoencaRemedios.stream().filter((PacienteDoencaRemedio p) -> p.getTurno().equals("tarde") ).collect(Collectors.toList());
		} else if(hora > 18 && hora <= 24) {
			return pacienteDoencaRemedios.stream().filter((PacienteDoencaRemedio p) -> p.getTurno().equals("noite") ).collect(Collectors.toList());	
		}
		return null;
	}
	
//	@ResponseBody
//	@RequestMapping(value = "/insertRegistro/{id}")
//	public int insereRegistro(@PathVariable(value = "id") int id) {
//		new PacienteHistoricoRepository().insereRegistroMedicamento(id, "teste_remedio", "manha");
//		DadosMemoria.getInstance().carregaTabelaPacienteHistorico();
//		return 1;
//	}
	
	@ResponseBody
	@RequestMapping(value = "/insertRegistro/{id}/{remedio}/{turno}")
	public int insereRegistro(@PathVariable(value = "id") int id, @PathVariable(value = "remedio") String remedio, @PathVariable(value = "turno") String turno) {
		
		new PacienteHistoricoRepository().insereRegistroMedicamento(id, remedio, turno);
		DadosMemoria.getInstance().carregaTabelaPacienteHistorico();
		return 1;
	}

}
