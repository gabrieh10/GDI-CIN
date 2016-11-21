package teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connect {
	
		private static Connection conn = null;
		private static java.sql.Statement st;
		private static ResultSet rs;
		private static String sql;
		
		public static void main(String[] args) throws SQLException {
			conectarOracle("jdbc:oracle:thin:System/100696@localhost:1521:XE", "System", "100696");
			queryMySQL("select * from Pessoa");
		//	queryMySQL("")
			
			desconectarMySQL();
			//	conn = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.1.15:3306/control","root","tcc");
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


public static void desconectarMySQL(){
	try{
		conn.close();
		System.out.println("MYSQL Desconectado.");
	} catch(Exception erro){
		System.out.println("MYSQ Erro: "+erro);
		}
	}
}