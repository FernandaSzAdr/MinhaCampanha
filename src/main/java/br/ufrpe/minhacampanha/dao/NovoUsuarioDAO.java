package br.ufrpe.minhacampanha.dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import br.ufrpe.minhacampanha.domain.Instituicao;
import br.ufrpe.minhacampanha.domain.Login;
import br.ufrpe.minhacampanha.domain.Usuario;
import br.ufrpe.minhacampanha.util.ConnectionFactory;

public class NovoUsuarioDAO {
	public void novoInst(Usuario usuario, Instituicao instituicao, Login login) 
			throws Exception{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		try {
			connection.setAutoCommit(false);
			InstituicaoDAO instituicaoDAO = new InstituicaoDAO();
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			
			usuario.setLogin(login);
			usuarioDAO.criar(usuario);
			instituicaoDAO.criar(instituicao);
			
			connection.commit();
			
		} catch (Exception e) {
			connection.rollback();
			throw e; 
		} finally {
			ConnectionFactory.closeConnection(connection, stmt);
		}
	}
}
