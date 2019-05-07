package projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model.Paciente;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.repositories.PacienteRepository;

@Controller 
@RestController
public class PacienteController {

	@RequestMapping("/getPaciente")
	public List<Paciente> buscarPaciente() {
		return new PacienteRepository().getListPaciente();
	}
	 
	@ResponseBody
	@RequestMapping(value = "/getUmPaciente/{id}")
	public Paciente buscarPacient(@PathVariable(value = "id") Integer id) {
		return new PacienteRepository().getPaciente(id);
	}
}
