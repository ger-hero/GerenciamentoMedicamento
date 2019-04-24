package projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model.Medicamento;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.repositories.MedicamentoRepository;

@RestController
public class MedicamentoController {

	@RequestMapping("/getMedicamento")
	public List<Medicamento> buscarMedicamentos() {
		return new MedicamentoRepository().getListMedicamentos();
	}
	
}
