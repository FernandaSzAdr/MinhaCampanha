package br.ufrpe.minhacampanha.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.ufrpe.minhacampanha.domain.Login;
import br.ufrpe.minhacampanha.domain.Usuario;

public class UsuarioDAO {
	
	public void criar(Usuario user, Connection connection,  java.sql.PreparedStatement stmt)
			throws SQLException{		
		try{
			if (user.getData_vl_inicio() == null && user.getData_vl_fim() == null) {
				if (user.getInstituicao_vinculada() == 0) {
					String SQL = "INSERT INTO USUARIO (senha, login, email, dtcriacao, "
							+ "bool_ativado) VALUES(?,?,?,?,?)";
					stmt = connection.prepareStatement(SQL);
					
					stmt.setString(1, user.getLogin().getSenha());
					stmt.setString(2, user.getLogin().getLogin());
					stmt.setString(3, user.getEmail());
					stmt.setDate(4, java.sql.Date.valueOf(user.getData_criacao())); 
					stmt.setInt(5, user.getAtivo());
				}else {
					String SQL = "INSERT INTO USUARIO (senha, login, email, dtcriacao, id_inst, "
							+ "bool_ativado) VALUES(?,?,?,?,?,?)";
					stmt = connection.prepareStatement(SQL);
					
					stmt.setString(1, user.getLogin().getSenha());
					stmt.setString(2, user.getLogin().getLogin());
					stmt.setString(3, user.getEmail());
					stmt.setDate(4, java.sql.Date.valueOf(user.getData_criacao())); 
					stmt.setInt(5, user.getInstituicao_vinculada());
					stmt.setInt(6, user.getAtivo());
				}
				
			} else if (user.getData_vl_inicio() != null) {
				String SQL = "INSERT INTO USUARIO (senha, login, email, dtcriacao, id_inst, "
						+ "bool_ativado, data_vl_inicio) VALUES(?,?,?,?,?,?,?)";
				stmt = connection.prepareStatement(SQL);
				
				stmt.setString(1, user.getLogin().getSenha());
				stmt.setString(2, user.getLogin().getLogin());
				stmt.setString(3, user.getEmail());
				stmt.setDate(4, java.sql.Date.valueOf(user.getData_criacao())); 
				stmt.setInt(5, user.getInstituicao_vinculada());
				stmt.setInt(6, user.getAtivo());
				stmt.setDate(7, java.sql.Date.valueOf(user.getData_vl_inicio())); 
			}else if (user.getData_vl_inicio() != null && user.getData_vl_fim() != null) {
				String SQL = "INSERT INTO USUARIO (senha, login, email, dtcriacao, id_inst, "
						+ "bool_ativado, data_vl_inicio, data_vl_fim) VALUES(?,?,?,?,?,?,?,?)";
				stmt = connection.prepareStatement(SQL);
				
				stmt.setString(1, user.getLogin().getSenha());
				stmt.setString(2, user.getLogin().getLogin());
				stmt.setString(3, user.getEmail());
				stmt.setDate(4, java.sql.Date.valueOf(user.getData_criacao())); 
				stmt.setInt(5, user.getInstituicao_vinculada());
				stmt.setInt(6, user.getAtivo());
				stmt.setDate(7, java.sql.Date.valueOf(user.getData_vl_inicio())); 
				stmt.setDate(8, java.sql.Date.valueOf(user.getData_vl_fim()));
			}
			stmt.executeUpdate();
			
		}catch (SQLException ex){
			ex.printStackTrace();
			throw ex;
		}
	}
	
	public Usuario buscar(String login, String senha, Connection connection,  java.sql.PreparedStatement stmt)
			throws SQLException{		
		Usuario usuario = new Usuario();
		try {			
			String SQL = "SELECT * from usuario where login = ? and senha = ?";
			stmt = connection.prepareStatement(SQL);
			stmt.setString(1, login);
			stmt.setString(2, senha);
			
			Login loginbusca = new Login();
			
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				usuario.setCodigo(rs.getInt("idusuario"));
				usuario.setData_criacao(rs.getDate("dtcriacao").toLocalDate());
				usuario.setEmail(rs.getString("email"));
				loginbusca.setLogin(rs.getString("login"));
				loginbusca.setSenha(rs.getString("senha"));
				usuario.setLogin(loginbusca);
				usuario.setAtivo(rs.getInt("bool_ativado"));
				usuario.setInstituicao_vinculada(rs.getInt("id_inst"));
			}
		} catch (SQLException erro) {
			throw erro;
		}
		
		return usuario;
	}
	
	public List<Usuario> listar(Connection connection,  java.sql.PreparedStatement stmt)
			throws SQLException{
		ResultSet resultSet = null;
		
		List<Usuario> users = new ArrayList<Usuario>();
		
		try{
		
			stmt = connection.prepareStatement("SELECT * USUARIO");
			resultSet =stmt.executeQuery();
		
			while (resultSet.next()){
				
				Usuario user = new Usuario();
				user.setCodigo(resultSet.getInt("cod"));
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
		}
		
		return users;
		
	}
	
	public void update(Usuario user, Connection connection,  java.sql.PreparedStatement stmt) 
			throws SQLException{
		try{
			stmt = connection.prepareStatement("UPDATE 	USUARIO SET login = ?, email = ? WHERE cod = ?");
			stmt.setString(1, user.getLogin().getLogin());
			stmt.setString(2, user.getEmail());
			stmt.setLong(3,user.getCodigo());
			
			stmt.executeUpdate();
			
			//JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao atualizar - "+ex);
			
		}
	}
	
	public void excluir(Usuario user, Connection connection,  java.sql.PreparedStatement stmt) throws SQLException{
		try{
			stmt = connection.prepareStatement("DELETE FROM USUARIO WHERE cod = ?");
			stmt.setLong(1, user.getCodigo());
						
			stmt.executeUpdate();
			
			//JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso");
			
		}catch (SQLException ex){
			//JOptionPane.showMessageDialog(null, "Erro ao excluir - "+ex);
			
		}
	}
	
}

