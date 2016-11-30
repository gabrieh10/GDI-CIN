package teste;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
					Ingrediente i = new Ingrediente(id, nomeIngrediente, bytes);										
					salvarFoto(i);
					return i;
				}else{
					return null;				
				}		
		}

		
		public void inserirIngrediente(int id, String nome, String caminhoFoto){
			try{
				BufferedImage imagem = ImageIO.read(new File(caminhoFoto));   
				ByteArrayOutputStream baos = new ByteArrayOutputStream();   // crio um OS de array de bytes
				ImageIO.write(imagem, "jpg", baos);   // Uso o write pra escrever os dados da imagem no OS do array de bytes
				 						
				String sql = "insert into tb_ingrediente values(tp_ingrediente(?, ?, ?))";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				ps.setString(2, nome);
			    ps.setBytes(3, baos.toByteArray());
				
				ps.executeQuery();
			}catch(Exception e){
				e.printStackTrace();
			
		}
	}
		public void atualizarIngrediente(int id, String nome, String caminhoFoto) throws SQLException{
			try{
				BufferedImage imagem = ImageIO.read(new File(caminhoFoto));   
				ByteArrayOutputStream baos = new ByteArrayOutputStream();   // crio um OS de array de bytes
				ImageIO.write(imagem, "jpg", baos);   // Uso o write pra escrever os dados da imagem no OS do array de bytes			
				
				String sql = "update tb_ingrediente set nome = ?, foto = ? where id = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(3, id);
				ps.setString(1, nome);
			    ps.setBytes(2, baos.toByteArray());
			    ps.executeQuery();
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
			}
		public void removerIngrediente(int id)throws SQLException{
			try{
				String sql = "delete from tb_ingrediente i where i.id = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				ps.executeQuery();
			}catch(Exception E){
				E.printStackTrace();
			}
		}
		public String salvarFoto(Ingrediente k){
			String aux="C:\\Users\\Otávio Vera Cruz\\Pictures"+k.getNome()+".jpg";
			try{			     
			 FileOutputStream fos = new FileOutputStream(aux);
		     fos.write(k.getFoto());
		     fos.flush();
		     fos.close(); 
		     
		 }
		 catch(Exception e){
		    e.printStackTrace();
		}
			return aux;
	}	
		
}