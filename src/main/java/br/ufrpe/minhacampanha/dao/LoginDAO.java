package br.ufrpe.minhacampanha.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.ufrpe.minhacampanha.util.ConnectionFactory;
import  br.ufrpe.minhacampanha.domain.*;
/**
 * 
 * @author raiss
 *
 */
public class LoginDAO {
	//Funcao checa o usuario e a senha para Logar no sistema
	public boolean efetuarLogin(Login tentativa) {
		Login sistema = new Login();
		boolean logado = false;
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		ResultSet resultSet = null;
		
		try {
			
			stmt = connection.prepareStatement("SELECT login, senha FROM USUARIO WHERE login = ?");
			resultSet =stmt.executeQuery();
			if(resultSet == null) {
				//Usuario não cadastrado???
			}
			while(resultSet.next()) { //Isso é necessario?
				sistema.setLogin(resultSet.getString("login"));
				sistema.setSenha(resultSet.getString("senha"));
			}
			
		}catch(SQLException ex) {
			
		}
		if(sistema != null) {
			if(sistema.equals(tentativa)) {
				logado = true;
			}
		}
		
		//TODO: SQL block
		return logado;
	}
	public void criar(Login new_login) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try {
			stmt = connection.prepareStatement("INSERT INTO Login (login, senha) VALUES (?,?)");
			stmt.setString(1, new_login.getLogin());
			stmt.setString(2, new_login.getSenha());
		}catch (SQLException ex) {
			//TODO: exception Login
		}finally {
			ConnectionFactory.closeConnection(connection, stmt);
		}
	}
	
	public List<Login> listar() throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		ResultSet resultSet = null;
		
		List<Login> logins = new ArrayList<Login>();
		
		try{
		
			stmt = connection.prepareStatement("SELECT * FROM Login");
			resultSet =stmt.executeQuery();
		
			while (resultSet.next()){
				
				Login log = new Login();
				log.setLogin(resultSet.getString("login"));
				log.setSenha(resultSet.getString("senha"));
				
				
				logins.add(log);
			 }
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao listar - "+ex);
		}finally{
			ConnectionFactory.closeConnection(connection, stmt, resultSet);
		}
		
		return logins;
	}
	
	
	public void update(Login log) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("UPDATE Login SET senha = ?, login = ?");
			stmt.setString(1, log.getSenha());
			stmt.setString(2, log.getLogin());
			
			
			stmt.executeUpdate();
			
			//JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao atualizar - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
	}
	
	public void excluir(Login log) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("DELETE FROM Login WHERE login = ?");
			stmt.setString(1, log.getLogin());
						
			stmt.executeUpdate();
			
			//JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso");
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao excluir - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
		
	}
}



