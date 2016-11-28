package teste;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.*;

public class RepositorioFuncionario {
	private Connection con;
	
		public RepositorioFuncionario(Connection con){
			this.con = con;
		}
		
		public void buscaFuncionario(String nome) throws SQLException{			
			String sql = "select * from tb_funcionario where nome = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
	         	String cpf = rs.getString("cpf");
				String nomeFuncionario = rs.getString("Nome");
				String sexo = rs.getString("sexo");
      			String dataNascimento = rs.getString("data_nascimento");
				
      			double salario = rs.getDouble("salario");
			}	
			
		//	return new Funcionario(cpf, nomeFuncionario, sexo, dataNascimento, arrayTelefones, salario, supervisor)
			
		}
		
			
}