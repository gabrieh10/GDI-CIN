package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import teste.Connect;
import teste.Funcionario;
import teste.RepositorioFuncionario;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class Funcionariogui extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNomeFun;
	private JTextField textFieldCpfFun;
	private JTextField textFieldSexoFun;
	private JTextField textFieldTelFun;
	private JTextField textFieldDataFun;
	private JTextField textFieldCargo;
	private JTextField textFieldSal;
	private JTextField textFieldSupervisor;
	private JTextPane textPane;
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
		
		textFieldNomeFun = new JTextField();
		textFieldNomeFun.setColumns(10);
		textFieldNomeFun.setBounds(66, 74, 213, 20);
		panel.add(textFieldNomeFun);
		
		JLabel label_1 = new JLabel("CPF:");
		label_1.setBounds(10, 105, 36, 14);
		panel.add(label_1);
		
		textFieldCpfFun = new JTextField();
		textFieldCpfFun.setColumns(10);
		textFieldCpfFun.setBounds(66, 105, 213, 20);
		panel.add(textFieldCpfFun);
		
		JLabel label_3 = new JLabel("Sexo:");
		label_3.setBounds(10, 136, 36, 14);
		panel.add(label_3);
		
		textFieldSexoFun = new JTextField();
		textFieldSexoFun.setColumns(10);
		textFieldSexoFun.setBounds(66, 136, 213, 20);
		panel.add(textFieldSexoFun);
		
		JLabel label_4 = new JLabel("Telefone:");
		label_4.setBounds(10, 167, 46, 14);
		panel.add(label_4);
		
		textFieldTelFun = new JTextField();
		textFieldTelFun.setColumns(10);
		textFieldTelFun.setBounds(66, 164, 213, 20);
		panel.add(textFieldTelFun);
		
		JLabel label_6 = new JLabel("Data Nasc:");
		label_6.setBounds(10, 205, 53, 14);
		panel.add(label_6);
		
		textFieldDataFun = new JTextField();
		textFieldDataFun.setColumns(10);
		textFieldDataFun.setBounds(66, 202, 213, 20);
		panel.add(textFieldDataFun);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(10, 243, 53, 14);
		panel.add(lblCargo);
		
		textFieldCargo = new JTextField();
		textFieldCargo.setColumns(10);
		textFieldCargo.setBounds(66, 240, 213, 20);
		panel.add(textFieldCargo);
		
		JLabel lblSalrio = new JLabel("Sal\u00E1rio:");
		lblSalrio.setBounds(293, 74, 53, 14);
		panel.add(lblSalrio);
		
		textFieldSal = new JTextField();
		textFieldSal.setColumns(10);
		textFieldSal.setBounds(345, 71, 213, 20);
		panel.add(textFieldSal);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome=textFieldNomeFun.getText();
				String cpf=textFieldCpfFun.getText();
				String sexo=textFieldSexoFun.getText();
				String data=textFieldDataFun.getText();
				String telefone=textFieldTelFun.getText();
				String []telefones={telefone};
				String cargo=textFieldCargo.getText();
				String sal=textFieldSal.getText();
				double salario=Double.parseDouble(sal);
				String cpfSupervisor=textFieldSupervisor.getText();
				
				Connect.init();
				RepositorioFuncionario rep=new RepositorioFuncionario(Connect.getConnection());
				try {
					rep.inserirFuncionario(cpf, nome, sexo, data, telefones, cargo, salario, cpfSupervisor);
					textPane.setText("Funcionário inserido com Sucesso!");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally{
					Connect.close();
				}
				
			}
		});
		btnInserir.setBounds(10, 367, 89, 23);
		panel.add(btnInserir);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome=textFieldNomeFun.getText();				
				Connect.init();
				RepositorioFuncionario rep=new RepositorioFuncionario(Connect.getConnection());
				try {
					Funcionario aux=rep.buscaNome(nome);
					textPane.setText(aux.toString());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally{
					Connect.close();
				}
			}
		});
		btnPesquisar.setBounds(135, 367, 89, 23);
		panel.add(btnPesquisar);
		
		JLabel lblSupervisor = new JLabel("Supervisor:");
		lblSupervisor.setBounds(289, 105, 57, 14);
		panel.add(lblSupervisor);
		
		textFieldSupervisor = new JTextField();
		textFieldSupervisor.setColumns(10);
		textFieldSupervisor.setBounds(345, 102, 213, 20);
		panel.add(textFieldSupervisor);
		
		JButton btnPesquisarPorCpf = new JButton("Pesquisar por Cpf");
		btnPesquisarPorCpf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cpf=textFieldCpfFun.getText();
				Connect.init();
				RepositorioFuncionario rep=new RepositorioFuncionario(Connect.getConnection());
				try {
					Funcionario aux=rep.buscaCPF(cpf);
					if(aux==null)textPane.setText("Funcionário não Existe!");
						
					else textPane.setText(aux.toString());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally{
					Connect.close();
				}
			}
				
		});
		btnPesquisarPorCpf.setBounds(249, 367, 147, 23);
		panel.add(btnPesquisarPorCpf);
		
		textPane = new JTextPane();
		textPane.setBounds(293, 161, 255, 193);
		panel.add(textPane);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf=textFieldCpfFun.getText();
				Connect.init();
				RepositorioFuncionario rep=new RepositorioFuncionario(Connect.getConnection());
				try {
					rep.removerFuncionario(cpf);
					textPane.setText("Funcionário removido com sucesso!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally{
					Connect.close();
				}
			}
		});
		btnRemover.setBounds(421, 367, 89, 23);
		panel.add(btnRemover);
	}

}
