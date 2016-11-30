package teste;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Struct;
import java.util.ArrayList;

import oracle.sql.REF;
import oracle.sql.STRUCT;

public class RepositorioFarmacia {
	private Connection con;
	
		public RepositorioFarmacia(Connection con){
			this.con = con;
		}
		
		public Farmacia buscaNome(String nome) throws SQLException{			
			String sql = "select * from tb_farmacia where nome = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			
				if(rs.next()){
					int id = rs.getInt("id");
					String nomeFarmacia = rs.getString("nome");		
				
					Object array = (Object) rs.getObject("telefone");
					String telefone = (String)((STRUCT)array).getAttributes()[0];
									
					Object objetoEndereco = (Object) rs.getObject("endereco");
					String cep = (String)((STRUCT)objetoEndereco).getAttributes()[0];
					String numero = (String)((STRUCT)objetoEndereco).getAttributes()[1].toString();
					String rua = (String)((STRUCT)objetoEndereco).getAttributes()[2];
					Endereco endereco = new Endereco(cep, Integer.parseInt(numero), rua);
					
					Array array2 = rs.getArray("funcionarios");
					Object[] funcionarios = (Object[])array2.getArray();
         		    String[] arrayFuncionarios = new String[funcionarios.length];
                    
         		    for (int i = 0; i < funcionarios.length; i++) {
                    	STRUCT address = (STRUCT) ((REF) funcionarios[i]).getSTRUCT();		
                        Object[] attrib = address.getAttributes();
                        arrayFuncionarios[i] = (String)attrib[1];
                    } 
                    
                      return new Farmacia(id, nomeFarmacia, telefone, endereco, arrayFuncionarios);
                                   
				}else{
					return null;				
				}
		}
		
		public Farmacia buscaID(int identificador) throws SQLException{			
			String sql = "select * from tb_farmacia where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, identificador);
			ResultSet rs = ps.executeQuery();
			
				if(rs.next()){
					int id = rs.getInt("id");
					String nomeFarmacia = rs.getString("nome");		
				
					Object array = (Object) rs.getObject("telefone");
					String telefone = (String)((STRUCT)array).getAttributes()[0];
									
					Object objetoEndereco = (Object) rs.getObject("endereco");
					String cep = (String)((STRUCT)objetoEndereco).getAttributes()[0];
					String numero = (String)((STRUCT)objetoEndereco).getAttributes()[1].toString();
					String rua = (String)((STRUCT)objetoEndereco).getAttributes()[2];
					Endereco endereco = new Endereco(cep, Integer.parseInt(numero), rua);
					
					Array array2 = rs.getArray("funcionarios");
					Object[] funcionarios = (Object[])array2.getArray();
         		    String[] arrayFuncionarios = new String[funcionarios.length];
                    
         		    for (int i = 0; i < funcionarios.length; i++) {
                    	STRUCT address = (STRUCT) ((REF) funcionarios[i]).getSTRUCT();		
                        Object[] attrib = address.getAttributes();
                        arrayFuncionarios[i] = (String)attrib[1];
                    } 
                    
                      return new Farmacia(id, nomeFarmacia, telefone, endereco, arrayFuncionarios);
                                   
				}else{
					return null;				
				}
		}

		
//falta completar
		public void inserirFarmacia(int id, String nome, String telefone, Endereco endereco){
			try{
				String sql = "insert into tb_farmacia values(tp_farmacia(?, ?, tp_telefone(?), tp_endereco(?,?,?),tp_nt_funcionarios()))";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				ps.setString(2, nome);
				ps.setString(3, telefone);
				ps.setString(4, endereco.getCep());
				ps.setInt(5, endereco.getNumero());
				ps.setString(6, endereco.getRua());
								
				ps.executeQuery();
			}catch(Exception e){
				e.printStackTrace();
			
		}
			
	}
	
		public void removerFarmacia(int id){
			try{
				String sql = "delete from tb_farmacia f where f.id = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				ps.executeQuery();
			}catch(Exception E){
				E.printStackTrace();
			}
		}
		
		public void inserirFuncionarios(String cpfFuncionario, int idFarmacia) throws SQLException{
			try{
			String sql = "insert into table(select fa.funcionarios from tb_farmacia fa where id = ?) values ((select ref(f) FROM tb_funcionario f where f.cpf = ?))";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idFarmacia);
			ps.setString(2, cpfFuncionario);
			ps.executeQuery();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
/*		public String qntFuncionarios(int qntFuncionarios) {		
			String resultado = "tp_nt_funcionarios(null)";	
			if (qntFuncionarios != 0) {
				resultado = "tp_telefones(";
				String fone = "tp_telefone(?)";
				
				for(int i = 0; i < qtdTelefones; i++){
					resultado += fone;
					
					if(i < qtdTelefones-1) {
						resultado += ", ";
					}
				}
				
				resultado += ")";
			}
					
			return resultado;
		}
	*/	
		
}