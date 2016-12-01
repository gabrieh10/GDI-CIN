package teste;

public class Endereco {
	

	private String cep;
	private int numero;
	private String rua;


	public Endereco(String cep, int numero, String rua){
		this.cep = cep;
		this.numero = numero;
		this.rua = rua;
	}


	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	@Override
	public String toString() {
		return "Endereco:"+"\n"+
				"CEP:"+ cep +"\n"+  
				"Número:" + numero + 
				 "\n"+"Rua:" + rua;
	}
	
}

