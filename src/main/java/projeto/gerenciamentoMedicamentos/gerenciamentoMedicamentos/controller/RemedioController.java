package projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model.Remedio;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.repositories.RemedioRepository;

@RestController
public class RemedioController {

	@RequestMapping("/getRemedios")
	public List<Remedio> buscarMedicamentos() {
		return new RemedioRepository().getListRemedios();
	}
	
}
