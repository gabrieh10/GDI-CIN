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

public class Laboratoriogui extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Laboratoriogui frame = new Laboratoriogui();
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
	public Laboratoriogui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblid = new JLabel("ID:");
		lblid.setBounds(91, 148, 60, 14);
		contentPane.add(lblid);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(168, 145, 198, 20);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);
		
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setBounds(91, 179, 60, 14);
		contentPane.add(labelNome);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(168, 176, 198, 20);
		contentPane.add(textField);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.setBounds(156, 277, 89, 23);
		contentPane.add(btnInserir);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPesquisar.setBounds(286, 277, 89, 23);
		contentPane.add(btnPesquisar);
		
		JLabel label = new JLabel("Preecha os dados:");
		label.setBounds(118, 56, 127, 14);
		contentPane.add(label);
	}

}
