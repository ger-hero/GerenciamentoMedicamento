package projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model.Doenca;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.repositories.DoencaRepository;

@RestController
public class DoencaController {

	@RequestMapping("/getDoenca")
	public List<Doenca> buscarDoenca() {
		return new DoencaRepository().getListDoenca();
	}
}
