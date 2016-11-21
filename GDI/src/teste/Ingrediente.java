package teste;

public class Ingrediente {
	private int id;
	private String nome;
	private byte[] foto;
	
	public Ingrediente(int id, String nome, byte[] foto){
		this.id = id;
		this.nome = nome;
		this.foto = foto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
}
