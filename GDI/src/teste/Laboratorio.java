package teste;

public class Laboratorio {
	private int id;
	private String descricao;
	
	public Laboratorio(int id, String descricao){
		this.id = id;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Laboratorio:"+"\n"
				+ "ID: " + id +"\n"+
				"Descrição:"+"\n" + descricao;
	}
	
	
}
