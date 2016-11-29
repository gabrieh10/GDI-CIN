package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 574, 464);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEscolhaUmaOpo = new JLabel("Escolha uma op\u00E7\u00E3o:");
		lblEscolhaUmaOpo.setBounds(105, 113, 139, 14);
		frame.getContentPane().add(lblEscolhaUmaOpo);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  Clientegui cliente=new Clientegui();
			  cliente.setVisible(true);
			  
			}
		});
		btnCliente.setBounds(105, 216, 89, 23);
		frame.getContentPane().add(btnCliente);
		
		JButton btnFuncionrio = new JButton("Funcion\u00E1rio");
		btnFuncionrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionariogui fun=new Funcionariogui();
				fun.setVisible(true);
				
			}
		});
		btnFuncionrio.setBounds(223, 216, 107, 23);
		frame.getContentPane().add(btnFuncionrio);
		
		JButton btnFarmcia = new JButton("Farm\u00E1cia");
		btnFarmcia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Farmaciagui farm=new Farmaciagui();
				farm.setVisible(true);
			}
		});
		btnFarmcia.setBounds(105, 268, 89, 23);
		frame.getContentPane().add(btnFarmcia);
		
		JButton btnLab = new JButton("Laborat\u00F3rio");
		btnLab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Laboratoriogui lab=new Laboratoriogui();
				lab.setVisible(true);
			}
		});
		btnLab.setBounds(223, 268, 107, 23);
		frame.getContentPane().add(btnLab);
		
		JButton btnIngredientes = new JButton("Ingredientes");
		btnIngredientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ingredientegui ing=new Ingredientegui();
				ing.setVisible(true);
				
			}
		});
		btnIngredientes.setBounds(353, 216, 100, 23);
		frame.getContentPane().add(btnIngredientes);
	}
}
