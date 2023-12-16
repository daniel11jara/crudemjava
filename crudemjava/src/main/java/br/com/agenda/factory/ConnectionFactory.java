package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	//nome do usuario do mysql
	private static final String USERNAME = "root";
	
	//senha do banco
	private static final String PASSWORD = "admin";
	
	//caminho do banco de dados
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";
	//"jdbc:mysql://127.0.0.1:3306/dbagenda?userTimezone=true&serverTimezone=UTC";
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	//conectando com o banco
	public static Connection createConnectionToMySQL() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		return connection;
	}
	
	public static void main(String[] args) throws Exception {
		Connection con = createConnectionToMySQL();
		
		if(con!=null) {
			System.out.println("Conexao obtida com sucesso");
			con.close();
		}
	}

}
