package teste;

import java.math.BigDecimal;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import oracle.sql.*;

import oracle.jdbc.*;

public class RepositorioCliente {
	private Connection con;
	
		public RepositorioCliente(Connection con){
			this.con = con;
		}
		
		public Cliente buscaCliente(String nome) throws SQLException{			
			String sql = "select * from tb_cliente where nome = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			
				if(rs.next()){
	         	String cpf = rs.getString("cpf");
				String nomeCliente = rs.getString("Nome");
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
      			for(int i=0;i<objeto.length;i++) System.out.println(telefones[i]);
      			
      			
				double peso = rs.getDouble("peso");
				
				Object objetoEndereco = (Object) rs.getObject("endereco");
				
				String cep = (String)((STRUCT)objetoEndereco).getAttributes()[0];
				String numero = (String)((STRUCT)objetoEndereco).getAttributes()[1].toString();
				String rua = (String)((STRUCT)objetoEndereco).getAttributes()[2];
				Endereco endereco = new Endereco(cep, Integer.parseInt(numero), rua);
					
				return new Cliente(cpf, nomeCliente, sexo, dataNascimento, telefones, peso, endereco);
							
				
				}else{		
					return null;
				}
		}
}

