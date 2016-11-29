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

public class Funcionariogui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textFieldCargo;
	private JTextField textFieldSal;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Funcionariogui frame = new Funcionariogui();
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
	public Funcionariogui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 558, 425);
		contentPane.add(panel);
		
		JLabel label_5 = new JLabel("Preecha os dados:");
		label_5.setBounds(43, 49, 127, 14);
		panel.add(label_5);
		
		JLabel label = new JLabel("Nome:");
		label.setBounds(10, 74, 36, 14);
		panel.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(66, 74, 213, 20);
		panel.add(textField);
		
		JLabel label_1 = new JLabel("CPF:");
		label_1.setBounds(10, 105, 36, 14);
		panel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(66, 105, 213, 20);
		panel.add(textField_1);
		
		JLabel label_2 = new JLabel("Peso");
		label_2.setBounds(10, 136, 36, 14);
		panel.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(66, 136, 213, 20);
		panel.add(textField_2);
		
		JLabel label_3 = new JLabel("Sexo:");
		label_3.setBounds(10, 173, 36, 14);
		panel.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(66, 173, 213, 20);
		panel.add(textField_3);
		
		JLabel label_4 = new JLabel("Telefone:");
		label_4.setBounds(10, 204, 46, 14);
		panel.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(66, 201, 213, 20);
		panel.add(textField_4);
		
		JLabel label_6 = new JLabel("Data Nasc:");
		label_6.setBounds(10, 242, 53, 14);
		panel.add(label_6);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(66, 239, 213, 20);
		panel.add(textField_5);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(10, 280, 53, 14);
		panel.add(lblCargo);
		
		textFieldCargo = new JTextField();
		textFieldCargo.setColumns(10);
		textFieldCargo.setBounds(66, 277, 213, 20);
		panel.add(textFieldCargo);
		
		JLabel lblSalrio = new JLabel("Sal\u00E1rio:");
		lblSalrio.setBounds(293, 74, 53, 14);
		panel.add(lblSalrio);
		
		textFieldSal = new JTextField();
		textFieldSal.setColumns(10);
		textFieldSal.setBounds(345, 71, 213, 20);
		panel.add(textFieldSal);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.setBounds(172, 365, 89, 23);
		panel.add(btnInserir);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPesquisar.setBounds(297, 365, 89, 23);
		panel.add(btnPesquisar);
		
		JLabel lblSupervisor = new JLabel("Supervisor:");
		lblSupervisor.setBounds(289, 105, 57, 14);
		panel.add(lblSupervisor);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(345, 102, 213, 20);
		panel.add(textField_6);
	}

}
