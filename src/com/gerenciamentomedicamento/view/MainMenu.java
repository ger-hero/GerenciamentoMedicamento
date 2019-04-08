package com.gerenciamentomedicamento.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainMenu extends JFrame implements ActionListener {
	JMenuBar menu;
	JMenu menu_arquivo;
	JMenuItem arquivo_novopaciente;
	Menu addPaciente;
	

	public MainMenu() {
		setTitle("Gerenciamento de Medicamentos");
		setSize(550, 450);
		setLocation(450, 200);
		getContentPane().setLayout(null);
		inicializaCampos();
		adicionaComponentes();
		arquivo_novopaciente.addActionListener(this);
	}
	
	public void inicializaCampos() {
		menu = new JMenuBar();
		menu_arquivo = new JMenu("Arquivo");
		arquivo_novopaciente = new JMenuItem("Novo paciente");
	}
	public void adicionaComponentes() {
		setJMenuBar(menu);
		menu.add(menu_arquivo);
		menu_arquivo.add(arquivo_novopaciente);
	}
	public void actionPerformed(ActionEvent e) {
		addPaciente = new Menu();
		addPaciente.setVisible(true);
	}
}