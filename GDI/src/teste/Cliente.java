package teste;

public class Cliente extends Pessoa {
	private int peso;
	private Endereco endereco;
	public Cliente(String cpf, String nome, String sexo, String data_nascimento, String[] tp_telefones, int peso, Endereco endereco) {
		super(cpf, nome, sexo, data_nascimento, tp_telefones);
		this.peso = peso;
		this.endereco = endereco;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
