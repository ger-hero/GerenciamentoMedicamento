package projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testController {

	@RequestMapping("/")
	public String index() {
		return "html/index";
	}

	@RequestMapping("/remedios")
	public String remedios() {
		return "html/remedios";
	}

	@RequestMapping("/doencas")
	public String doencas() {
		return "html/doencas";
	}

	@RequestMapping("/pacientes")
	public String pacientes() {
		return "html/pacientes";
	}

	@RequestMapping("/historico")
	public String historico() {
		return "html/historico";
	}

	@RequestMapping(value = "/paciente/{id}")
	public String paciente(@PathVariable(value = "id") int id) {
		return "html/paciente";
	}

}
