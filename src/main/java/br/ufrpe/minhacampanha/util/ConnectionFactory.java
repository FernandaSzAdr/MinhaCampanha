package br.ufrpe.minhacampanha.util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.Connection;

public class ConnectionFactory {

    public static Connection getConnection() throws RuntimeException {
        try {
             Class.forName("com.mysql.jdbc.Driver");
            return (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/minha_campanha", "root", "1234");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Ocorreu um SQLException na ConnectionFactory", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Ocorreu um ClassNotFoundException na ConnectionFactory", ex);
        }
    }
    
public static void closeConnection(Connection connection){
		
		try {
			if (connection != null){
				connection.close();
			}	
		}catch (SQLException ex) {
			throw new RuntimeException("Não foi possível encerrar a conexão - ",ex);
		}
		
	}
	
	
	
	public static void closeConnection(java.sql.Connection connection, java.sql.PreparedStatement stmt){
			
		closeConnection((Connection) connection);
			try {
				if (stmt != null){
					stmt.close();
				}	
			}catch (SQLException ex) {
				throw new RuntimeException("Não foi possível encerrar a conexão - ",ex);
			}
			
		}
	
	
	public static void closeConnection(java.sql.Connection connection, java.sql.PreparedStatement stmt, ResultSet resultset){
		closeConnection(connection, stmt);
		
		try {
			if (resultset != null){
				resultset.close();
			}	
		}catch (SQLException ex) {
			throw new RuntimeException("Não foi possível encerrar a conexão - ",ex);
		}
	}
}
