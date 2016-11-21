package teste;

public class Pessoa {
	private String cpf;
	private String nome;
	private String sexo;
	private String data_nascimento;
	private String[] tp_telefones;
	
	public Pessoa(String cpf, String nome, String sexo, String data_nascimento, String[] tp_telefones){
		this.cpf = cpf;
		this.nome = nome;
		this.sexo = sexo;
		this.data_nascimento = data_nascimento;
		this.tp_telefones = tp_telefones;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String[] getTp_telefones() {
		return tp_telefones;
	}

	public void setTp_telefones(String[] tp_telefones) {
		this.tp_telefones = tp_telefones;
	}
}
