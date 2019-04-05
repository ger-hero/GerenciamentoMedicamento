package com.gerenciamentomedicamento.view;
import java.awt.*;
import javax.swing.*;
public class SplashScreen extends JWindow {
	//Atributos
	private int duration;
	
	//Construtor
	public SplashScreen(int duration) {
		this.duration = duration;
	}
	
	//Metotos
	public void showSplash() {	//Metodo simples para fazer uma Splash Screen pro app
		JPanel content = (JPanel)getContentPane();
		content.setBackground(Color.WHITE); //A cor de nossa janela será branca
		int width = 450;	//Largura
		int height = 115;	//Altura
		Dimension tamanhoTela = Toolkit.getDefaultToolkit().getScreenSize(); //a resolucao da nossa tela
		int x = (tamanhoTela.width - width) / 2;
		int y = (tamanhoTela.height - height) / 2;
		setBounds(x, y, width, height);
		JLabel label = new JLabel(new ImageIcon("stub.png"));
		JLabel version = new JLabel("0.0.1-SNAPSHOT",JLabel.CENTER);
		version.setFont(new Font("Sans-Serif", Font.BOLD, 12));
		content.add(label, BorderLayout.CENTER);
		content.add(version, BorderLayout.SOUTH);
		Color black = (new Color(0, 0, 0));
		content.setBorder(BorderFactory.createLineBorder(black, 1)); //Cria uma borda da cor e da grossura especificada
		setVisible(true); //Visivel?
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("Exceção na Splash Screen");
		}
		
	}
	public void showAndExit() {
		showSplash();
		this.dispose();
	}
}
