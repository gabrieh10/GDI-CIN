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
		//	
			String[] teste = {"122331312", "121321312"};
	//		System.out.println(teste.length);
			Endereco endereco = new Endereco("53070130", 126, "Rua de Tal2");
	//		RepositorioCliente a = new RepositorioCliente(conn);
		//	a.inserirCliente("99999999990", "Cliente de Tal", "m", "10/06/1996", teste, 82, endereco);
//			System.out.println(a.buscaCliente("Luiz Reis").getCpf());
		//	System.out.println(d.getPeso());
			//	System.out.println(a.qntTelefones(5));
	/*		
			RepositorioFuncionario f = new RepositorioFuncionario(conn);
			f.inserirFuncionario("99999999999", "Funcionario de Tal", "m", "12/06/1996", teste, "Balconista", 1500, "10000000011");
			Funcionario[] aa = new Funcionario[f.relatorioFuncionarios().size()];
			f.relatorioFuncionarios().toArray(aa);
			for(int i=0;i<aa.length;i++){
				System.out.println(aa[i].getNome());
			}
		*/	
			
//			RepositorioFuncionario b = new RepositorioFuncionario(conn);
	//		Funcionario x = b.buscaFuncionario("Jose Freire");
	//		System.out.println(x.getNome());
		//	System.out.println(x.getSupervisor());
	//		RepositorioIngrediente i = new RepositorioIngrediente(conn);
		//	i.buscaIngrediente("Vitamina");	
		//	i.inserirIngrediente(18, "RemedioTeste");
			
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