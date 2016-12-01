package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import teste.Connect;
import teste.Laboratorio;
import teste.RepositorioLaboratorio;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class Laboratoriogui extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textField;
	private JTextPane textPaneLab;
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
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connect.init();
				
				int id = Integer.parseInt(textFieldID.getText());
				String nome = textField.getText();
				
				RepositorioLaboratorio repo = new RepositorioLaboratorio(Connect.getConnection());
				try {
					repo.inserirLaboratorio(id,nome);
					textPaneLab.setText("Laboratório inserido com sucesso!");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				finally {
					Connect.close();
				}
				
			}
		});
		btnInserir.setBounds(91, 277, 89, 23);
		contentPane.add(btnInserir);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connect.init();
				
				int id = Integer.parseInt(textFieldID.getText());
				
				RepositorioLaboratorio repo = new RepositorioLaboratorio(Connect.getConnection());
				try {
					Laboratorio lab = repo.buscaID(id);
					if(lab == null) textPaneLab.setText("Laboratorio não encontrado.");  
					else textPaneLab.setText(lab.toString());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				finally {
					Connect.close();
				}
				
				
			}
		});
		btnPesquisar.setBounds(216, 277, 89, 23);
		contentPane.add(btnPesquisar);
		
		JLabel label = new JLabel("Preecha os dados:");
		label.setBounds(118, 56, 127, 14);
		contentPane.add(label);
		
		textPaneLab = new JTextPane();
		textPaneLab.setBounds(376, 120, 172, 180);
		contentPane.add(textPaneLab);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int id=Integer.parseInt(textFieldID.getText());
				
				Connect.init();
				RepositorioLaboratorio rep=new RepositorioLaboratorio(Connect.getConnection());
				try {
					rep.removerLaboratorio(id);;
					textPaneLab.setText("Laboratório removido com sucesso!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				
			}
		});
		btnRemover.setBounds(91, 323, 89, 23);
		contentPane.add(btnRemover);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome=textField.getText();
				int id=Integer.parseInt(textFieldID.getText());
				
				Connect.init();
				RepositorioLaboratorio rep=new RepositorioLaboratorio(Connect.getConnection());
				try {
					rep.atualizarLaboratorio(id, nome);
					textPaneLab.setText("Laboratório atualizado com sucesso!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
				
				
			}
		});
		btnAtualizar.setBounds(216, 323, 89, 23);
		contentPane.add(btnAtualizar);
	}
}
