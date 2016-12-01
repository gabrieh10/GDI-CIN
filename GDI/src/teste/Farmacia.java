package teste;

import java.util.Arrays;

public class Farmacia {
	private String nome;
	private int id;
	private String telefone;
	private Endereco endereco;
	private String[] funcionarios;
	
	public Farmacia(int id, String nome, String telefone, Endereco endereco, String[] funcionarios){
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.funcionarios = funcionarios;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String[] getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(String[] funcionarios) {
		this.funcionarios = funcionarios;
	}

	@Override
	public String toString() {
		String func="";
		
		for(int i=0;i<this.getFuncionarios().length-1;i++){
			if(this.getFuncionarios()[i]!=null)func+=this.getFuncionarios()[i].toString()+"\n";
			else func="Não existem funcionários!";
		}
		
		return "Farmacia "+"\n"
				+ "Nome:" + nome + "\n"+
				"ID:" + id +"\n"+
				"Telefone:"+ telefone  +"\n"
				+this.getEndereco().toString()+"\n"
				+ "Funcionários da Farmácia: " + func ;
	}
	
	

}
