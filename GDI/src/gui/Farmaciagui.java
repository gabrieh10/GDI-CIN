package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Farmaciagui extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldId;
	private JTextField textFieldTelefone;
	private JTextField textField_6;
	private JTextField textFieldCpfFuncFarm;
	private JTextField textFieldIdFarmFun;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Farmaciagui frame = new Farmaciagui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Farmaciagui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 608, 414);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Nome:");
		label.setBounds(10, 117, 36, 14);
		panel.add(label);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(66, 117, 213, 20);
		panel.add(textFieldNome);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 148, 36, 14);
		panel.add(lblId);
		
		textFieldId = new JTextField();
		textFieldId.setColumns(10);
		textFieldId.setBounds(66, 148, 213, 20);
		panel.add(textFieldId);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 182, 46, 14);
		panel.add(lblTelefone);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(66, 179, 213, 20);
		panel.add(textFieldTelefone);
		
		JLabel label_6 = new JLabel("Endere\u00E7o:");
		label_6.setBounds(10, 210, 53, 14);
		panel.add(label_6);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(66, 210, 213, 20);
		panel.add(textField_6);
		
		JButton buttonBuscarFarm = new JButton("Pesquisar");
		buttonBuscarFarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonBuscarFarm.setBounds(204, 298, 89, 23);
		panel.add(buttonBuscarFarm);
		
		JLabel label_7 = new JLabel("Preecha os dados:");
		label_7.setBounds(10, 66, 127, 14);
		panel.add(label_7);
		
		JLabel lblPesquisar = new JLabel("Adicionar Funcion\u00E1rio:");
		lblPesquisar.setBounds(329, 66, 116, 14);
		panel.add(lblPesquisar);
		
		JButton btnInserirFarm = new JButton("Inserir");
		btnInserirFarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnInserirFarm.setBounds(66, 298, 89, 23);
		panel.add(btnInserirFarm);
		
		textFieldCpfFuncFarm = new JTextField();
		textFieldCpfFuncFarm.setColumns(10);
		textFieldCpfFuncFarm.setBounds(385, 117, 213, 20);
		panel.add(textFieldCpfFuncFarm);
		
		JLabel lblNewLabel = new JLabel("Cpf:");
		lblNewLabel.setBounds(329, 117, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("ID:");
		label_1.setBounds(329, 148, 36, 14);
		panel.add(label_1);
		
		textFieldIdFarmFun = new JTextField();
		textFieldIdFarmFun.setColumns(10);
		textFieldIdFarmFun.setBounds(385, 148, 213, 20);
		panel.add(textFieldIdFarmFun);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemover.setBounds(327, 298, 89, 23);
		panel.add(btnRemover);
		
		JButton btnAddFuncionro = new JButton("Add Funcion\u00E1ro");
		btnAddFuncionro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddFuncionro.setBounds(385, 206, 107, 23);
		panel.add(btnAddFuncionro);
	}

}
