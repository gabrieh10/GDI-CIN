package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class Ingredientegui extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldId;

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
		lblNome.setBounds(67, 158, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(67, 194, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblImg = new JLabel("Img:");
		lblImg.setBounds(319, 126, 46, 14);
		contentPane.add(lblImg);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.setBounds(80, 339, 89, 23);
		contentPane.add(btnInserir);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(221, 339, 89, 23);
		contentPane.add(btnPesquisar);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setBounds(375, 122, 89, 23);
		contentPane.add(btnProcurar);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(101, 155, 168, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldId = new JTextField();
		textFieldId.setColumns(10);
		textFieldId.setBounds(101, 191, 168, 20);
		contentPane.add(textFieldId);
		
		JLabel lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon("C:\\Users\\Ot\u00E1vio Vera Cruz\\Downloads\\Prancheta 1xxxhdpi.png"));
		lblImagem.setBounds(375, 157, 121, 120);
		contentPane.add(lblImagem);
	}

}
