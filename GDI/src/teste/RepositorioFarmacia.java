package teste;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.sql.REF;
import oracle.sql.STRUCT;

public class RepositorioFarmacia {
	private Connection con;
	
		public RepositorioFarmacia(Connection con){
			this.con = con;
		}
		
		public void buscaFarmacia(String nome) throws SQLException{			
			String sql = "select * from tb_farmacia where nome = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			
				if(rs.next()){
					int id = rs.getInt("id");
					String nomeFarmacia = rs.getString("nome");		
				
					Object array = (Object) rs.getObject("telefone");
					String telefone = (String)((STRUCT)array).getAttributes()[0];
					System.out.println(telefone);	
					
					
					Object objetoEndereco = (Object) rs.getObject("endereco");
					
					String cep = (String)((STRUCT)objetoEndereco).getAttributes()[0];
					String numero = (String)((STRUCT)objetoEndereco).getAttributes()[1].toString();
					String rua = (String)((STRUCT)objetoEndereco).getAttributes()[2];
					Endereco endereco = new Endereco(cep, Integer.parseInt(numero), rua);
					
					
			/*		Array func = rs.getArray("funcionarios");
					Object[] objetoFunc = (Object[])func.getArray();
					String[] testando = new String[objetoFunc.length];					
					for (int i=0; i<objetoFunc.length; i++){
						Object funcionariosSaida = (Object) objetoFunc[i];			    
						String nomeSuper = (String)((STRUCT)funcionariosSaida).getAttributes()[1];
						testando[i] = nomeSuper;
					}
				*/	
					
					
		//		for(int i=0;i<testando.length;i++) System.out.println(testando[i]);
			
					
					//return null;
			//		return new Ingrediente(id, nomeIngrediente, Blob);
				}else{
				//	return null;				
				}
				
		}
}