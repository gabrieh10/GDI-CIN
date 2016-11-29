package teste;

public class Funcionario extends Pessoa {
	private String cargo;
	private double salario;
	private String supervisor;
	
	public Funcionario(String cpf, String nome, String sexo, String data_nascimento, String[] tp_telefones, String cargo,
			double salario, String supervisor) {
		
			super(cpf, nome, sexo, data_nascimento, tp_telefones);
			this.cargo = cargo;
			this.salario = salario;
			this.supervisor = supervisor;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

}
