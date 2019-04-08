package com.gerenciamentomedicamento.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame{
	JLabel lbNomePaciente;
	JTextField tfPaciente;
	
	JLabel lbIdadePaciente; 		// idade
	JTextField tfIdadePaciente;
	
	JLabel lbRgPaciente;			// rg
	JTextField tfRgPaciente;
	
	JLabel lbTelefonePaciente;		//telefone
	JTextField tfTelefonePaciente;
	
	JLabel lbAgressivoPaciente;		// agressivo 
	JComboBox<String> cbAgressivo;
	
	public Menu() {
		setTitle("Cadastro de Pacientes");
        setSize(550, 450);
        setLocation(450, 200);
        getContentPane().setLayout(null);
        inicializaLabels();
        inicializaTextFields();
        adicionaComponentes();
        organizaLabels();
	}
	
	public void inicializaLabels() {
		lbNomePaciente = new JLabel("Paciente");
		lbIdadePaciente = new JLabel("Idade");
		lbRgPaciente = new JLabel("RG");
		lbTelefonePaciente = new JLabel("Telefone");
		lbAgressivoPaciente = new JLabel("Agressivo");
	}
	
	public void adicionaComponentes() {
		getContentPane().add(lbNomePaciente);
        getContentPane().add(tfPaciente);
        
        getContentPane().add(lbIdadePaciente);
        getContentPane().add(tfIdadePaciente);
        
        getContentPane().add(lbRgPaciente);
        getContentPane().add(tfRgPaciente);
        
        getContentPane().add(lbTelefonePaciente);
        getContentPane().add(tfTelefonePaciente);
        
        getContentPane().add(lbAgressivoPaciente);
        getContentPane().add(cbAgressivo);
        
	}
	public void inicializaTextFields() {
		tfPaciente = new JTextField("");
		tfIdadePaciente = new JTextField("");
		tfRgPaciente = new JTextField("");
		tfTelefonePaciente = new JTextField("");
		cbAgressivo = new JComboBox<String>(new String[] {"Sim", "Não"});

	}
	
	public void organizaLabels() {
		lbNomePaciente.setBounds(20, 20, 100, 15);
		tfPaciente.setBounds(20, 40, 150, 25);
		
		lbIdadePaciente.setBounds(180, 20, 100, 25);
		tfIdadePaciente.setBounds(180, 40, 50, 25);
		
		lbRgPaciente.setBounds(240, 20, 150, 25);
		tfRgPaciente.setBounds(240, 40, 150, 25);
		
		lbTelefonePaciente.setBounds(20, 70, 100, 25);
		tfTelefonePaciente.setBounds(20, 90, 100, 25);
		
		lbAgressivoPaciente.setBounds(130, 70, 75, 25);
	}
}
