package br.ufrpe.minhacampanha.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.mysql.jdbc.Connection;

import br.ufrpe.minhacampanha.util.ConnectionFactory;
import  br.ufrpe.minhacampanha.domain.*;
/**
 * 
 * @author raiss
 *
 */
public class LoginDAO {
	
	//Pega os dados do usuario caso exista (Depois do login)
	@SuppressWarnings("deprecation")
	public Usuario pegaUser(Login tentativa) throws SQLException {
		Usuario logado = new Usuario();
		try{
			Connection connection = ConnectionFactory.getConnection();
			java.sql.PreparedStatement stmt = null;
			ResultSet resultSet = null;
			
			stmt = connection.prepareStatement("SELECT * FROM USUARIO WHERE login = ? and senha = ?");
			stmt.setString(1, tentativa.getLogin());
			stmt.setString(2, tentativa.getSenha());
			resultSet =stmt.executeQuery();
			
			/* Se não ele retorna nulo */
			if (resultSet.next()) {
				/* Aqui ele faz a conversão de tipo Date para LocalDate*/
				/*TODO tem erro aqui
				 * if (!resultSet.getDate("data_vl_fim").equals("0000-00-00")) {
					logado.setData_vl_fim(resultSet.getDate("data_vl_fim").toLocalDate());
				} else if (!resultSet.getDate("data_vl_inicio").equals("0000-00-00")) {
					logado.setData_vl_inicio(resultSet.getDate("data_vl_inicio").toLocalDate());
				}*/
				
				logado.setLogin(tentativa);
				logado.setCodigo(resultSet.getInt("idusuario"));
				logado.setData_criacao(resultSet.getDate("dtcriacao").toLocalDate());
				logado.setEmail(resultSet.getString("email"));
				logado.setInstituicao_vinculada(resultSet.getInt("id_inst"));
			} else {
				logado = null;
			}
			ConnectionFactory.closeConnection(connection, stmt);
			
		}catch(SQLException ex) {
			throw ex;
		}
		return logado;
	}
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
		
			while(resultSet.next()) { //Isso � necessario?
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
	
	/*public void criar(Login new_login) throws SQLException{
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
		
	}*/
}



