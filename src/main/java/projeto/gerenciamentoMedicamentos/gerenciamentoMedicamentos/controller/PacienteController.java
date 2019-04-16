package projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model.Paciente;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.repositories.PacienteRepository;

@RestController
public class PacienteController {
	
	@RequestMapping("/getPaciente")
	public List<Paciente> buscarPaciente(){
		PacienteRepository repository = new PacienteRepository();
		
		return repository.buscarPaciente(new Paciente());
	}
}
