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
		
		public void buscaIngrediente(String nome) throws SQLException, IOException{			
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
					
					System.out.println(id);
					System.out.println(nomeIngrediente);
										
		//			return new Ingrediente(id, nomeIngrediente, i);
				}else{
			//		return null;				
				}
				
		}
}