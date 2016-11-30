package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import teste.Connect;
import teste.Ingrediente;
import teste.RepositorioIngrediente;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class Ingredientegui extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNomeIng;
	private JTextField textFieldIdIng;
	private JTextField textFieldCaminhoImg;
	private JLabel lblImagem;
	private JTextPane textPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ingredientegui frame = new Ingredientegui();
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
	public Ingredientegui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPreenchaOsDados = new JLabel("Preencha os Dados:");
		lblPreenchaOsDados.setBounds(52, 89, 105, 14);
		contentPane.add(lblPreenchaOsDados);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(52, 126, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(62, 154, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblImg = new JLabel("Img:");
		lblImg.setBounds(319, 126, 46, 14);
		contentPane.add(lblImg);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idText=textFieldIdIng.getText();
				int id=Integer.parseInt(idText);
				String nome=textFieldNomeIng.getText();
				String caminho=textFieldCaminhoImg.getText();
						
				Connect.init();
				RepositorioIngrediente rep=new RepositorioIngrediente(Connect.getConnection());
				rep.inserirIngrediente(id, nome, caminho);
				
			}
		});
		btnInserir.setBounds(80, 339, 89, 23);
		contentPane.add(btnInserir);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idText=textFieldIdIng.getText();
				int id=Integer.parseInt(idText);
				String nome=textFieldNomeIng.getText();
				
				Connect.init();
				RepositorioIngrediente rep=new RepositorioIngrediente(Connect.getConnection());
				try {
					Ingrediente ing=rep.buscaID(id);
					if(ing == null){
						textPane.setText("Ingrediente não encontrado!");
					}else{
						lblImagem.setIcon(new ImageIcon(ing.getFoto()));
						textPane.setText(ing.toString());
						
					}
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnPesquisar.setBounds(196, 339, 89, 23);
		contentPane.add(btnPesquisar);
		
		textFieldNomeIng = new JTextField();
		textFieldNomeIng.setBounds(101, 123, 168, 20);
		contentPane.add(textFieldNomeIng);
		textFieldNomeIng.setColumns(10);
		
		textFieldIdIng = new JTextField();
		textFieldIdIng.setColumns(10);
		textFieldIdIng.setBounds(101, 151, 168, 20);
		contentPane.add(textFieldIdIng);
		
		lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon("C:\\Users\\Ot\u00E1vio Vera Cruz\\Downloads\\Prancheta 1xxxhdpi.png"));
		lblImagem.setBounds(375, 157, 121, 120);
		contentPane.add(lblImagem);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String idText=textFieldIdIng.getText();
				int id=Integer.parseInt(idText);
				String nome=textFieldNomeIng.getText();
				String caminho=textFieldCaminhoImg.getText();
						
				Connect.init();
				RepositorioIngrediente rep=new RepositorioIngrediente(Connect.getConnection());
				try {
					rep.atualizarIngrediente(id, nome, caminho);
					Ingrediente ing=rep.buscaID(id);
					lblImagem.setIcon(new ImageIcon(ing.getFoto()));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAtualizar.setBounds(319, 339, 89, 23);
		contentPane.add(btnAtualizar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idText=textFieldIdIng.getText();
				int id=Integer.parseInt(idText);	
				Connect.init();
				RepositorioIngrediente rep=new RepositorioIngrediente(Connect.getConnection());
				try {
					rep.removerIngrediente(id);
					textPane.setText("Ingrediente removido com sucesso!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnRemover.setBounds(439, 339, 89, 23);
		contentPane.add(btnRemover);
		
		textFieldCaminhoImg = new JTextField();
		textFieldCaminhoImg.setBounds(345, 123, 203, 20);
		contentPane.add(textFieldCaminhoImg);
		textFieldCaminhoImg.setColumns(10);
		
		textPane = new JTextPane();
		textPane.setBounds(101, 195, 168, 87);
		contentPane.add(textPane);
	}
}
