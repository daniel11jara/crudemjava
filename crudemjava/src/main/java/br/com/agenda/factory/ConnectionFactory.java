package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	//nome do usuario do mysql
	private static final String USERNAME = "root";
	
	//senha do banco
	private static final String PASSWORD = "";
	
	//caminho do banco de dados
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";
	
	//conectando com o banco
	public static Connection createConnectionToMySQL() throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		return connection;
	}

}
