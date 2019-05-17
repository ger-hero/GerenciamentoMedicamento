package projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.DadosMemoria;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model.Remedio;

@RestController
public class RemedioController {

	@RequestMapping("/getRemedios")
	public List<Remedio> buscarMedicamentos() {
		return DadosMemoria.getRemedios();
	}
}
