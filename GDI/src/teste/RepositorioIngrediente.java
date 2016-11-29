package teste;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;

public class RepositorioIngrediente {
	private Connection con;
	
		public RepositorioIngrediente(Connection con){
			this.con = con;
		}
		
		public Ingrediente buscaNome(String nome) throws SQLException, IOException{			
			String sql = "select * from tb_ingrediente where nome = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			
			ByteArrayInputStream in = null;
			BufferedImage img = null;
			Blob fotoBlob = null;

			byte bytes[] = null;
			
				if(rs.next()){
					int id = rs.getInt("id");
					String nomeIngrediente = rs.getString("nome");
					fotoBlob = rs.getBlob("foto");
					
					if(fotoBlob != null){
						bytes = fotoBlob.getBytes(1, (int) fotoBlob.length());
						in = new ByteArrayInputStream(bytes);
						img = ImageIO.read(in);
					}
							
					return new Ingrediente(id, nomeIngrediente, bytes);
		
				}else{
					return null;				
				}		
		}

		public Ingrediente buscaID(int identificador) throws SQLException, IOException{			
			String sql = "select * from tb_ingrediente where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, identificador);
			ResultSet rs = ps.executeQuery();
			
			ByteArrayInputStream in = null;
			BufferedImage img = null;
			Blob fotoBlob = null;

			byte bytes[] = null;
			
				if(rs.next()){
					int id = rs.getInt("id");
					String nomeIngrediente = rs.getString("nome");
					fotoBlob = rs.getBlob("foto");
					
					if(fotoBlob != null){
						bytes = fotoBlob.getBytes(1, (int) fotoBlob.length());
						in = new ByteArrayInputStream(bytes);
						img = ImageIO.read(in);
					}
															
					return new Ingrediente(id, nomeIngrediente, bytes);
				}else{
					return null;				
				}		
		}

		
		public void inserirIngrediente(int id, String nome){
			try{
				String sql = "insert into tb_ingrediente values(tp_ingrediente(?, ?, EMPTY_BLOB()))";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				ps.setString(2, nome);
		//		ps.setBlob(3, );
				ps.executeQuery();
			}catch(Exception e){
				e.printStackTrace();
			
		}
	}
}