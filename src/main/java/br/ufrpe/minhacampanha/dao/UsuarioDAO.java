package br.ufrpe.minhacampanha.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.ufrpe.minhacampanha.domain.Login;
import br.ufrpe.minhacampanha.domain.Usuario;
import br.ufrpe.minhacampanha.util.ConnectionFactory;

public class UsuarioDAO {
	public void criar(Usuario user) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("INSERT INTO USUARIO (login, senha, email, dtcriacao,id_inst, bool_ativado, data_vl_inicio, data_vl_fim) VALUES(?,?,?,?,?,?,?,?)");
			stmt.setString(1, user.getLogin().getLogin());
			stmt.setString(2, user.getLogin().getSenha());
			stmt.setString(3, user.getEmail());
			//stmt.setDate(4, user.getData_criacao()); TODO:
			//stmt.setLong(5, user.getInstituicao_vinculada());
			//stmt.setBoolean(6,1);
			//stmt.setDate(7, user.getData_vl_inicio()); 
			//stmt.setDate(7, user.getData_vl_fim()()); 
			
			
			//JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso");
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao salvar - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
	}
	
	public List<Usuario> listar() throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		ResultSet resultSet = null;
		
		List<Usuario> users = new ArrayList<Usuario>();
		
		try{
		
			stmt = connection.prepareStatement("SELECT * USUARIO");
			resultSet =stmt.executeQuery();
		
			while (resultSet.next()){
				
				Usuario user = new Usuario();
				user.setCodigo(resultSet.getLong("cod"));
				//user.setData_vl_inicio(resultSet.getDate("data_vl_inicio"));
				//user.setData_vl_fim(resultSet.getDate("data_vl_fim"));
				user.setEmail(resultSet.getString("email"));
				Login login = new Login();
				login.setLogin(resultSet.getString("login"));
				user.setLogin(login);
				
				
				
				users.add(user);
			 }
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao listar - "+ex);
		}finally{
			ConnectionFactory.closeConnection(connection, stmt, resultSet);
		}
		
		return users;
		
	}
	
	public void update(Usuario user) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("UPDATE 	USUARIO SET login = ?, email = ? WHERE cod = ?");
			stmt.setString(1, user.getLogin().getLogin());
			stmt.setString(2, user.getEmail());
			stmt.setLong(3,user.getCodigo());
			
			stmt.executeUpdate();
			
			//JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao atualizar - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
	}
	
	public void excluir(Usuario user) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement("DELETE FROM USUARIO WHERE cod = ?");
			stmt.setLong(1, user.getCodigo());
						
			stmt.executeUpdate();
			
			//JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso");
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao excluir - "+ex);
			
		}finally{
			ConnectionFactory.closeConnection(connection, stmt);
		}
		
	}
	
}
