package teste;

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
		
	
		
		public static void main(String[] args) throws SQLException, IOException {
			conectarOracle("jdbc:oracle:thin:System/100696@localhost:1521:XE", "system", "100696");
		//	queryMySQL("select * from tb_funcionario");
		//	queryMySQL("")
	//		RepositorioCliente a = new RepositorioCliente(conn);
		//	a.buscaCliente("Luiz Reis");
		//	RepositorioFarmacia r = new RepositorioFarmacia(conn);
			//r.buscaFarmacia("Big Ben");
			RepositorioFuncionario b = new RepositorioFuncionario(conn);
			Funcionario x = b.buscaFuncionario("Jose Freire");
			System.out.println(x.getNome());
			System.out.println(x.getSupervisor());
	//		RepositorioIngrediente i = new RepositorioIngrediente(conn);
		//	i.buscaIngrediente("Vitamina");	
			
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