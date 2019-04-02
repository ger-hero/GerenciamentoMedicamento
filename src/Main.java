import java.util.Date;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String nomePaciente;
		int idadePaciente;
		String dataInternacao;
		String RG;
		boolean agressivo;
		String validaAgressivo;
		
		
		
		Scanner sc1 = new Scanner(System.in); 
		
		
	    System.out.println("Digite o nome do paciente");
	    nomePaciente = sc1.next();
		
	    System.out.println("Digite a idade do Paciente");
	    idadePaciente = sc1.nextInt();
	    
	    System.out.println("Digite a data da internação do Paciente");
	    dataInternacao = sc1.next();
	    
	    System.out.println("Digite o RG");
	    
	    RG = sc1.next();
	    
	    System.out.println("Agressivo? (S/N)");
	    validaAgressivo = sc1.next();
	    
	    while (!validaAgressivo.equalsIgnoreCase("S") 
	    		&& !validaAgressivo.equalsIgnoreCase("N")) {
	    	System.out.println("Agressivo? Informe apenas S ou N!");
		    validaAgressivo = sc1.next();
	    }
	    
	    if(validaAgressivo.equalsIgnoreCase("S"))
	    	agressivo = true;
	    else
	    	agressivo = false;
	     

	    

	}

}
