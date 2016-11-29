package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Clientegui extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCpf;
	private JLabel lblSexo;
	private JTextField textFieldSexo;
	private JLabel lblTelefone;
	private JTextField textFieldTelefone;
	private JLabel lblData;
	private JTextField textFieldData;
	private JLabel lblEndereo;
	private JTextField textFieldEnderco;
	private JButton btnInserir;
	private JLabel lblPreechaOsDados;
	private JButton btnPesquisar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientegui frame = new Clientegui();
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
	public Clientegui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeDaFarmcia = new JLabel("Nome:");
		lblNomeDaFarmcia.setBounds(33, 71, 36, 14);
		contentPane.add(lblNomeDaFarmcia);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(89, 71, 213, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(33, 102, 36, 14);
		contentPane.add(lblCpf);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setColumns(10);
		textFieldCpf.setBounds(89, 102, 213, 20);
		contentPane.add(textFieldCpf);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setBounds(33, 133, 36, 14);
		contentPane.add(lblPeso);
		
		JTextField textFieldPeso = new JTextField();
		textFieldPeso.setColumns(10);
		textFieldPeso.setBounds(89, 133, 213, 20);
		contentPane.add(textFieldPeso);
		
		lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(33, 170, 36, 14);
		contentPane.add(lblSexo);
		
		textFieldSexo = new JTextField();
		textFieldSexo.setColumns(10);
		textFieldSexo.setBounds(89, 170, 213, 20);
		contentPane.add(textFieldSexo);
		
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(33, 211, 46, 14);
		contentPane.add(lblTelefone);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(89, 208, 213, 20);
		contentPane.add(textFieldTelefone);
		
		lblData = new JLabel("Data Nasc:");
		lblData.setBounds(33, 239, 53, 14);
		contentPane.add(lblData);
		
		textFieldData = new JTextField();
		textFieldData.setColumns(10);
		textFieldData.setBounds(89, 236, 213, 20);
		contentPane.add(textFieldData);
		
		lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(33, 277, 53, 14);
		contentPane.add(lblEndereo);
		
		textFieldEnderco = new JTextField();
		textFieldEnderco.setColumns(10);
		textFieldEnderco.setBounds(89, 274, 213, 20);
		contentPane.add(textFieldEnderco);
		
		btnInserir = new JButton("Inserir");
		btnInserir.setBounds(173, 334, 89, 23);
		contentPane.add(btnInserir);
		
		lblPreechaOsDados = new JLabel("Preecha os dados:");
		lblPreechaOsDados.setBounds(89, 24, 127, 14);
		contentPane.add(lblPreechaOsDados);
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(304, 334, 89, 23);
		contentPane.add(btnPesquisar);
	}

}
