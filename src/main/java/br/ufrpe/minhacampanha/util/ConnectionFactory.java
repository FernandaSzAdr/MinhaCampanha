package br.ufrpe.minhacampanha.util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectionFactory {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/minha_campanha";
	private static final String USER = "root";
	private static final String PASS = "1234";
	
	public static Connection getConnection () {
			
			try {
				Class.forName(DRIVER);
				
				return (Connection) DriverManager.getConnection(URL, USER, PASS); 
						
			} catch (SQLException ex) {
				throw new RuntimeException("Erro na conexï¿½o: ",ex);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Classe não encontrada: ",e);
			}			
	}
	
	
	public static void closeConnection(Connection connection){
		
		try {
			if (connection != null){
				connection.close();
			}	
		}catch (SQLException ex) {
			throw new RuntimeException("Nï¿½o foi possï¿½vel encerrar a conexï¿½o - ",ex);
		}
		
	}
	
	
	
	public static void closeConnection(java.sql.Connection connection, java.sql.PreparedStatement stmt){
			
		closeConnection((Connection) connection);
			try {
				if (stmt != null){
					stmt.close();
				}	
			}catch (SQLException ex) {
				throw new RuntimeException("Nï¿½o foi possï¿½vel encerrar a conexï¿½o - ",ex);
			}
			
		}
	
	
	public static void closeConnection(java.sql.Connection connection, java.sql.PreparedStatement stmt, ResultSet resultset){
		closeConnection(connection, stmt);
		
		try {
			if (resultset != null){
				resultset.close();
			}	
		}catch (SQLException ex) {
			throw new RuntimeException("Nï¿½o foi possï¿½vel encerrar a conexï¿½o - ",ex);
		}
		
	}
	
	
}