package br.ufrpe.minhacampanha.dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import br.ufrpe.minhacampanha.domain.Instituicao;
import br.ufrpe.minhacampanha.domain.Login;
import br.ufrpe.minhacampanha.domain.PessoaFisica;
import br.ufrpe.minhacampanha.domain.Usuario;
import br.ufrpe.minhacampanha.util.ConnectionFactory;

public class NovoUsuarioDAO {
	public void novoInst(Usuario usuario, Instituicao instituicao, Login login) throws Exception{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		try {
			connection.setAutoCommit(false);
			InstituicaoDAO instituicaoDAO = new InstituicaoDAO();
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			
			instituicaoDAO.criar(instituicao);
			
			Instituicao codigo = instituicaoDAO.buscar(instituicao.getCnpj());
			usuario.setLogin(login);
			usuario.setInstituicao_vinculada(codigo.getCodigo());
			usuarioDAO.criar(usuario);
			
			connection.commit();
			
		} catch (Exception e) {
			connection.rollback();
			throw e; 
		} finally {
			ConnectionFactory.closeConnection(connection, stmt);
		}
	}
	
	public void novoPessoa(Usuario usuario, PessoaFisica pessoa, Login login) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		try {
			connection.setAutoCommit(false);
			PessoaFisicaDAO pessoaDAO = new PessoaFisicaDAO();
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			
			usuario.setLogin(login);
			usuarioDAO.criar(usuario);
			
			Usuario buscar = new Usuario();
			buscar = usuarioDAO.buscar(login.getLogin(), login.getSenha());
			pessoa.setId_usuario(buscar.getCodigo());
			pessoaDAO.criar(pessoa);
			
			connection.commit();
			
		} catch (Exception e) {
			connection.rollback();
			throw e; 
		} finally {
			ConnectionFactory.closeConnection(connection, stmt);
		}
	}
}
