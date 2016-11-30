package teste;

import java.math.BigDecimal;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import oracle.sql.*;

import oracle.jdbc.*;

public class RepositorioCliente {
	private Connection con;
	
		public RepositorioCliente(Connection con){
			this.con = con;
		}
		
		public ArrayList<Cliente> relatorioCliente() throws SQLException{
			String sql = "select * from tb_cliente";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<Cliente> clientes = new ArrayList();
			while(rs.next()){
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
      			
				double peso = rs.getDouble("peso");
				
				Object objetoEndereco = (Object) rs.getObject("endereco");
				
				String cep = (String)((STRUCT)objetoEndereco).getAttributes()[0];
				String numero = (String)((STRUCT)objetoEndereco).getAttributes()[1].toString();
				String rua = (String)((STRUCT)objetoEndereco).getAttributes()[2];
				Endereco endereco = new Endereco(cep, Integer.parseInt(numero), rua);
					
				clientes.add(new Cliente(cpf, nomeCliente, sexo, dataNascimento, telefones, peso, endereco));
			
			}
			return clientes;
		}
		
		
		public Cliente buscaNome(String nome) throws SQLException{			
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
		
		public Cliente buscaCPF(String cpfParametro) throws SQLException{			
			String sql = "select * from tb_cliente where cpf = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cpfParametro);
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

		
		
		public void inserirCliente(String cpf, String nomeCliente,String sexo,String dataNascimento,
		String[] telefones,double peso,Endereco endereco) throws SQLException{
			
			try{
			int tamanho = telefones.length;
				String sql = "insert into tb_cliente values (tp_cliente(?, ?, ?,to_date(?,'dd/mm/yyyy'),"+qntTelefones(tamanho)+",?, tp_endereco(?, ?, ?)))";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cpf);
			ps.setString(2, nomeCliente);
			ps.setString(3, sexo);
			ps.setString(4, dataNascimento);
			int indice = 5;		
			for(int i = 0; i < telefones.length; i++) {
				ps.setString(indice, telefones[i]);
				indice = indice+1;
			}
			ps.setDouble(indice, peso);
			ps.setString(indice+1, endereco.getCep());
			ps.setInt(indice+2, endereco.getNumero());
			ps.setString(indice+3, endereco.getRua());	
			ps.executeQuery();
		}catch(Exception E){
			E.printStackTrace();
		}
		
	}	

		public void removerCliente(String cpf){
			try{
				String sql = "delete from tb_cliente c where c.cpf = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, cpf);
				ps.executeQuery();
			}catch(Exception E){
				E.printStackTrace();
			}
		}
		
		public String qntTelefones(int qtdTelefones) {		
			String resultado = "tp_telefones(null)";	
			if (qtdTelefones != 0) {
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
		
}

