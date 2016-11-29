package teste;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.*;
import oracle.sql.REF;
import oracle.sql.STRUCT;

public class RepositorioFuncionario {
	private Connection con;
	
		public RepositorioFuncionario(Connection con){
			this.con = con;
		}
		
		public Funcionario buscaFuncionario(String nome) throws SQLException{			
			String sql = "select * from tb_funcionario where nome = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
	         	String cpf = rs.getString("cpf");
				String nomeFuncionario = rs.getString("Nome");
				String sexo = rs.getString("sexo");
      			String dataNascimento = rs.getString("data_nascimento");
				
      			Array array = rs.getArray("telefone");
				Object[] objeto = (Object[])array.getArray();
				
				String[] telefones = new String[5];
				
				for (int i=0; i<objeto.length; i++){
					Object telefone_Saida = (Object) objeto[i];
					String telefone = (String) ((STRUCT) telefone_Saida).getAttributes()[0];			    
				    telefones[i] = telefone;
				}
      			String cargo = rs.getString("cargo");
				double salario = rs.getDouble("salario");
      		
				REF supervisor = (REF) rs.getRef("supervisor");
				String nomeSupervisor = null;
				if (supervisor != null) {
					STRUCT supervisorStruct = (STRUCT) supervisor.getSTRUCT();				
					nomeSupervisor = (String) supervisorStruct.getAttributes()[1];			
				}
							
			return new Funcionario(cpf, nomeFuncionario, sexo, dataNascimento, telefones, cargo, salario, nomeSupervisor);	
			
      			
			}else{
				return null;
			}
			
	
		}
}
		
		
			
