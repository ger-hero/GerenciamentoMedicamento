package projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.DadosMemoria;
import projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos.model.PacienteHistorico;

@Controller
@RestController
public class HistoricoController {
	
	@RequestMapping("/getHistorico")
	public List<PacienteHistorico> buscarHistorico() {
		return DadosMemoria.getPacienteHistorico();
	}

}
