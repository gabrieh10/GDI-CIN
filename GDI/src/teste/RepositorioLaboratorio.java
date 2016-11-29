package teste;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.*;

public class RepositorioLaboratorio {
	private Connection con;
	
		public RepositorioLaboratorio(Connection con){
			this.con = con;
		}
		
		public Laboratorio buscaNome(String nome) throws SQLException{			
			String sql = "select * from tb_laboratorio where descricao = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			
				if(rs.next()){
					int id = rs.getInt("id");
					String descricao = rs.getString("descricao");
					return new Laboratorio(id, descricao);
				}else{
					return null;				
				}
		}
		
		public Laboratorio buscaID(int identificador) throws SQLException{			
			String sql = "select * from tb_laboratorio where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, identificador);
			ResultSet rs = ps.executeQuery();
			
				if(rs.next()){
					int id = rs.getInt("id");
					String descricao = rs.getString("descricao");
					return new Laboratorio(id, descricao);
				}else{
					return null;				
				}
		}
		
		public void inserirLaboratorio(int id, String descricao) throws SQLException{
		try{
			String sql = "insert into tb_laboratorio values(tp_laboratorio(?, ?))";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, descricao);
			ps.executeQuery();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		}
}