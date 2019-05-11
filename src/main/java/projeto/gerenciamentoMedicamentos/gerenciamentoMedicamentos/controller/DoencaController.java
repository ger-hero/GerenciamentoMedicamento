package projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.DadosMemoria;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model.Doenca;

@RestController
public class DoencaController {

	@RequestMapping("/getDoenca")
	public List<Doenca> buscarDoenca() {
		return DadosMemoria.getInstance().getDoencas();
	}
}
