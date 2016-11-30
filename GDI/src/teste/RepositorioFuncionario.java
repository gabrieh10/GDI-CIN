package teste;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.*;
import oracle.sql.REF;
import oracle.sql.STRUCT;

public class RepositorioFuncionario {
	private Connection con;
	
		public RepositorioFuncionario(Connection con){
			this.con = con;
		}
		
		public ArrayList<Funcionario> relatorioFuncionarios() throws SQLException{
			String sql = "select * from tb_funcionario";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<Funcionario> funcionarios = new ArrayList();
			while(rs.next()){
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
			funcionarios.add(new Funcionario(cpf, nomeFuncionario, sexo, dataNascimento, telefones, cargo, salario, nomeSupervisor));
			}
			return funcionarios;
		}	
		
		
		public Funcionario buscaNome(String nome) throws SQLException{			
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

		public Funcionario buscaCPF(String cpfParametro) throws SQLException{			
			String sql = "select * from tb_funcionario where cpf = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cpfParametro);
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

		
		
		public void inserirFuncionario(String cpf, String nomeCliente,String sexo,String dataNascimento,
				String[] telefones,String cargo, double salario, String cpfSupervisor) throws SQLException{
					
					try{
						String sql = "insert into tb_funcionario values (tp_funcionario(?, ?, ?,to_date(?,'dd/mm/yyyy'),"+qntTelefones(telefones.length)+",?,?,(select ref(F) from tb_funcionario F where F.cpf = ?)))";
					
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, cpf);
					ps.setString(2, nomeCliente);
					ps.setString(3, sexo);
					ps.setString(4, dataNascimento);
					int indice = 5;		
				//	ps.setString(5, telefones[]);
					for(int i = 0; i < telefones.length; i++) {
						ps.setString(indice, telefones[i]);
						indice = indice+1;
					}
					ps.setString(indice, cargo);
					ps.setDouble(indice+1, salario);
					ps.setString(indice+2, cpfSupervisor);
					ps.executeQuery();
				}catch(Exception E){
					E.printStackTrace();
				}
				
			}	
		
		public void removerFuncionario(String cpf){
			try{
				String sql = "delete from tb_funcionario f where f.cpf = ?";
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

