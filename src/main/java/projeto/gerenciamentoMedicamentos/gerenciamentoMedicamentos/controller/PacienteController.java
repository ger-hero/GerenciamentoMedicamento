package projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.DadosMemoria;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model.Paciente;

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
		List<Paciente> aux = DadosMemoria.getInstance().getPacientes()
				.stream()
				.filter((Paciente p) -> p.getId() == id)
				.collect(Collectors.toList());

		return aux.get(0);
	}
}
