package br.ufrpe.minhacampanha.util;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.Connection;

public class ConnectionFactory {

    public static Connection getConnection() throws RuntimeException {
        try {
             Class.forName("com.mysql.jdbc.Driver");
            return (Connection) DriverManager.getConnection("jdbc:mysql://localhost/minha_campanha", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Ocorreu um SQLException na ConnectionFactory", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Ocorreu um ClassNotFoundException na ConnectionFactory", ex);
        }
    }
}
