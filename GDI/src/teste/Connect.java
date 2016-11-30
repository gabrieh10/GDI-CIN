package teste;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connect {
	
		private static Connection conn = null;
		private static java.sql.Statement st;
		private static ResultSet rs;
		private static String sql;
		
	
	
		public static Connection getConnection(){
			return conn;
		}
		

		public static void init(){
			conectarOracle("jdbc:oracle:thin:System/Ota07vio@localhost:1521:XE", "system", "Ota07vio");
		}
		
		public static void conectarOracle(String host, String usuario, String senha){
			try{
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			} catch(Exception erro){
			
			}

				try{
					conn=DriverManager.getConnection(host, usuario, senha);
					System.out.println("MYSQL Conectado.");
				} catch(Exception erro){
					System.out.println("MYSQL Erro: "+erro);
				}
			}


public static ResultSet queryMySQL(String qry){
	try{
		st = conn.createStatement();
		sql = qry;
		rs = st.executeQuery(sql);
		while(rs.next()){
			String teste = rs.getString("nome");
			System.out.println(teste);
		}
	} catch(Exception erro){
		System.out.println("MYSQL Erro: "+erro);
		return null;
		}
	return rs;
	}


public static void close(){
	try{
		conn.close();
		System.out.println("MYSQL Desconectado.");
	} catch(Exception erro){
		System.out.println("MYSQ Erro: "+erro);
		}
	}
}