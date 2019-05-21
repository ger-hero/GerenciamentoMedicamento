package projeto.gerenciamentoMedicamentos.gerenciamentoMedicamentos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class GerenciamentoMedicamentosApplication {

	@RequestMapping("/")
	@ResponseBody
	private String home() {
		return "Hello World!";
	}

	public static void main(String[] args) {
		DadosMemoria.getInstance();
		SpringApplication.run(GerenciamentoMedicamentosApplication.class, args);
	}
}
