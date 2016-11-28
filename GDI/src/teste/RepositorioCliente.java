package teste;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.*;

public class RepositorioCliente {
	private Connection con;
	
		public RepositorioCliente(Connection con){
			this.con = con;
		}
		
		public void buscaCliente(String nome) throws SQLException{			
			String sql = "select * from tb_cliente where nome = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			
				if(rs.next()){
	         	String cpf = rs.getString("cpf");
				String nomeCliente = rs.getString("Nome");
				String sexo = rs.getString("sexo");
      			String dataNascimento = rs.getString("data_nascimento");
				Array telefones = rs.getArray("telefone");
				
				Object[] arrayTelefones = new String[5]; 
				arrayTelefones = (Object[])telefones.getArray();
				String[] stringTelefones = convert(arrayTelefones); 
				
				double peso = rs.getDouble("peso");
	//			String endereco = (String)rs.getObject("endereco");
				
				System.out.println(cpf);
				System.out.println(nomeCliente);
				System.out.println(sexo);
				System.out.println(dataNascimento);
		//		for (int i=0;i<arrayTelefones.length.;i++) arrayTelefones[i]=(String)telefones[i];
				
				for(int i=0; i<stringTelefones.length;i++){
					System.out.println(arrayTelefones[i].toString());
				}
				System.out.println(peso);
	//			System.out.println(endereco);
				
				}else{
					System.out.println("vazio");
				}
				
//				return new Cliente(cpf, nomeCliente, sexo, dataNascimento, arrayTelefones, peso, endereco);		
		}
		
		public String[] convert(Object[] source) {
            String[] strings = new String[source.length];
            for(int i = 0; i < source.length ; i++) {
                strings[i] = source[i].toString();
            }
            return strings;
        }


}

