package teste;

import java.sql.PreparedStatement;

public class Cliente extends Pessoa {
	private double peso;
	private Endereco endereco;
	public Cliente(String cpf, String nome, String sexo, String data_nascimento, String[] tp_telefones, double peso, Endereco endereco) {
		super(cpf, nome, sexo, data_nascimento, tp_telefones);
		this.peso = peso;
		this.endereco = endereco;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	/*
	public void consultaCliente(){
		 
	ps = getConnection().prepareStatement("insert into contatos (nome,email,endereco) values (?,?,?)");
		 preenche os valores
		stmt.setString(1, “xxx”);
	    stmt.setString(2, “contato@xxx.com.br”);
		stmt.setString(3, “R. xxxx 12”);
		
			PreparedStatement pstmt = conn.prepareStatement("Select * from tb_cliente
                  WHERE cpf = ?;");
           pstmt.setString(1, "110592");
		*/
	
	
}
