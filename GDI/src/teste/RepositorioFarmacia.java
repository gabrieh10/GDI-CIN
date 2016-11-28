package teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
					Object telefone = rs.getObject("telefone");
					System.out.println(nomeFarmacia);
					System.out.println(telefone);
					//return null;
			//		return new Ingrediente(id, nomeIngrediente, Blob);
				}else{
				//	return null;				
				}
				
		}
}