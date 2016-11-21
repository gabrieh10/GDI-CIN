package teste;

public class Receita {
	private int id;
	private String nome_remedio;
	private String nome_medico;
	private int quantidade;
	
	public Receita(int id, int quantidade, String nome_remedio, String nome_medico){
		this.id = id;
		this.quantidade = quantidade;
		this.nome_remedio = nome_remedio;
		this.nome_medico = nome_medico;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome_remedio() {
		return nome_remedio;
	}

	public void setNome_remedio(String nome_remedio) {
		this.nome_remedio = nome_remedio;
	}

	public String getNome_medico() {
		return nome_medico;
	}

	public void setNome_medico(String nome_medico) {
		this.nome_medico = nome_medico;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
