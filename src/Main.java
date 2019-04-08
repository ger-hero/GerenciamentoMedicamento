import java.util.Date;
import java.util.Scanner;
import com.gerenciamentomedicamento.view.*;


public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Exemplo menu = new Exemplo ();
		//menu.setVisible(true);
		SplashScreen splash = new SplashScreen(10000);
        splash.showAndExit();
        MainMenu aaa = new MainMenu();
        aaa.setVisible(true);
	}

}
