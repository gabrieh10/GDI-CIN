package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Farmaciagui extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldId;
	private JTextField textFieldTelefone;
	private JTextField textField_3;
	private JTextField textField_6;

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
		setBounds(100, 100, 574, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 522, 388);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Nome:");
		label.setBounds(29, 119, 36, 14);
		panel.add(label);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(107, 116, 213, 20);
		panel.add(textFieldNome);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(29, 150, 36, 14);
		panel.add(lblId);
		
		textFieldId = new JTextField();
		textFieldId.setColumns(10);
		textFieldId.setBounds(107, 147, 213, 20);
		panel.add(textFieldId);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(29, 184, 46, 14);
		panel.add(lblTelefone);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(107, 178, 213, 20);
		panel.add(textFieldTelefone);
		
		JLabel lblFuncionrios = new JLabel("Funcion\u00E1rios:");
		lblFuncionrios.setBounds(29, 224, 71, 14);
		panel.add(lblFuncionrios);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(107, 215, 213, 20);
		panel.add(textField_3);
		
		JLabel label_6 = new JLabel("Endere\u00E7o:");
		label_6.setBounds(29, 252, 53, 14);
		panel.add(label_6);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(107, 246, 213, 20);
		panel.add(textField_6);
		
		JButton button = new JButton("Pesquisar");
		button.setBounds(199, 328, 89, 23);
		panel.add(button);
		
		JLabel label_7 = new JLabel("Preecha os dados:");
		label_7.setBounds(63, 54, 127, 14);
		panel.add(label_7);
	}

}
