package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import teste.Connect;
import teste.Endereco;
import teste.Farmacia;
import teste.RepositorioFarmacia;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class Farmaciagui extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldId;
	private JTextField textFieldTelefone;
	private JTextField textField_6;
	private JTextField textFieldCpfFuncFarm;
	private JTextField textFieldIdFarmFun;
	private JTextField textField;
	private JTextField textFieldRuaFarm;
	private JTextPane textPaneFarm;

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
		setBounds(100, 100, 634, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 608, 447);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Nome:");
		label.setBounds(20, 78, 36, 14);
		panel.add(label);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(76, 78, 213, 20);
		panel.add(textFieldNome);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(20, 109, 36, 14);
		panel.add(lblId);
		
		textFieldId = new JTextField();
		textFieldId.setColumns(10);
		textFieldId.setBounds(76, 109, 213, 20);
		panel.add(textFieldId);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(20, 143, 46, 14);
		panel.add(lblTelefone);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(76, 140, 213, 20);
		panel.add(textFieldTelefone);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(20, 171, 53, 14);
		panel.add(lblCep);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(76, 171, 213, 20);
		panel.add(textField_6);
		
		JButton buttonBuscarFarm = new JButton("Pesquisar por Id");
		buttonBuscarFarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idText=textFieldId.getText();
				int id=Integer.parseInt(idText);
				Connect.init();
				RepositorioFarmacia rep=new RepositorioFarmacia(Connect.getConnection());
				try {
					Farmacia farm=rep.buscaID(id);
					if(farm==null)textPaneFarm.setText("Farmácia não encontrada!");
					else textPaneFarm.setText(farm.toString());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally{
					Connect.close();
				}
			}
		});
		buttonBuscarFarm.setBounds(20, 363, 116, 23);
		panel.add(buttonBuscarFarm);
		
		JLabel label_7 = new JLabel("Preecha os dados:");
		label_7.setBounds(20, 27, 127, 14);
		panel.add(label_7);
		
		JLabel lblPesquisar = new JLabel("Adicionar Funcion\u00E1rio:");
		lblPesquisar.setBounds(339, 27, 116, 14);
		panel.add(lblPesquisar);
		
		JButton btnInserirFarm = new JButton("Inserir");
		btnInserirFarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome=textFieldNome.getText();
				String idText=textFieldId.getText();
				int id=Integer.parseInt(idText);
				String telefone=textFieldTelefone.getText();
				String rua=textFieldRuaFarm.getText();
				String cep=textField_6.getText();
				String num=textField.getText();
				int numero=Integer.parseInt(num);
				Endereco end=new Endereco(cep,numero,rua);
								
				Connect.init();	
				RepositorioFarmacia rep=new RepositorioFarmacia(Connect.getConnection());
				try {
					rep.inserirFarmacia(id, nome, telefone, end);
					textPaneFarm.setText("Farmácia inserida com sucesso!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				finally{
					Connect.close();
				}				
				
			}
		});
		btnInserirFarm.setBounds(20, 308, 89, 23);
		panel.add(btnInserirFarm);
		
		textFieldCpfFuncFarm = new JTextField();
		textFieldCpfFuncFarm.setColumns(10);
		textFieldCpfFuncFarm.setBounds(395, 78, 213, 20);
		panel.add(textFieldCpfFuncFarm);
		
		JLabel lblNewLabel = new JLabel("Cpf:");
		lblNewLabel.setBounds(339, 78, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("ID:");
		label_1.setBounds(339, 109, 36, 14);
		panel.add(label_1);
		
		textFieldIdFarmFun = new JTextField();
		textFieldIdFarmFun.setColumns(10);
		textFieldIdFarmFun.setBounds(395, 109, 213, 20);
		panel.add(textFieldIdFarmFun);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idText=textFieldId.getText();
				int id=Integer.parseInt(idText);
				Connect.init();
				RepositorioFarmacia rep=new RepositorioFarmacia(Connect.getConnection());
				try {
					rep.removerFarmacia(id);
					textPaneFarm.setText("Removido com sucesso!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally{
					Connect.close();
				}				
			}
		});
		btnRemover.setBounds(145, 308, 89, 23);
		panel.add(btnRemover);
		
		JButton btnAddFuncionro = new JButton("Add Funcion\u00E1ro");
		btnAddFuncionro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cpf=textFieldCpfFuncFarm.getText();
				String idText=textFieldId.getText();
				int id=Integer.parseInt(idText);
				Connect.init();								 
				RepositorioFarmacia rep=new RepositorioFarmacia(Connect.getConnection());
				
				try {
					rep.inserirFuncionarios(cpf, id);
					textPaneFarm.setText("Funcionário inserido com sucesso!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally{
					Connect.close();
				}				
			}
		});
		btnAddFuncionro.setBounds(395, 143, 107, 23);
		panel.add(btnAddFuncionro);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setBounds(20, 203, 53, 14);
		panel.add(lblNmero);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(76, 203, 213, 20);
		panel.add(textField);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(20, 234, 53, 14);
		panel.add(lblRua);
		
		textFieldRuaFarm = new JTextField();
		textFieldRuaFarm.setColumns(10);
		textFieldRuaFarm.setBounds(76, 234, 213, 20);
		panel.add(textFieldRuaFarm);
		
		textPaneFarm = new JTextPane();
		textPaneFarm.setBounds(312, 182, 296, 265);
		panel.add(textPaneFarm);
		
		JButton buttonBuscarNome = new JButton("Pesquisar por Nome");
		buttonBuscarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome=textFieldNome.getText();
				Connect.init();
				RepositorioFarmacia rep=new RepositorioFarmacia(Connect.getConnection());
				try {
					
					Farmacia farm=rep.buscaNome(nome);
					if(farm==null)textPaneFarm.setText("Farmácia não encontrada!");
					else textPaneFarm.setText(farm.toString());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally{
					Connect.close();
				}	
			}
		
		});
		buttonBuscarNome.setBounds(146, 363, 143, 23);
		panel.add(buttonBuscarNome);
	}
}
