package br.ufrpe.minhacampanha.dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import br.ufrpe.minhacampanha.domain.Endereco;
import br.ufrpe.minhacampanha.domain.Instituicao;
import br.ufrpe.minhacampanha.domain.Instituicao_doadora;
import br.ufrpe.minhacampanha.domain.Instituicao_receptora;
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
			
			if (instituicao.getTipo_instituicao().equals("Receptora")) {
				Instituicao_receptoraDAO instituicao_rec_DAO = new Instituicao_receptoraDAO();
				Instituicao_receptora instituicao_recp = new Instituicao_receptora();
				instituicao_recp.setCodigo(codigo.getCodigo());
				instituicao_rec_DAO.criar(instituicao_recp);
			} else if (instituicao.getTipo_instituicao().equals("Doadora")) {
				Instituicao_doadoraDAO instituicao_do_DAO = new Instituicao_doadoraDAO();
				Instituicao_doadora instituicao_do = new Instituicao_doadora();
				instituicao_do.setCodigo(codigo.getCodigo());
				instituicao_do_DAO.criar(instituicao_do);
			}			
		} catch (SQLException e) {
			connection.rollback();
			throw e; 
		} finally {
			connection.commit();
			ConnectionFactory.closeConnection(connection, stmt);
		}
	}
	
	public void novoPessoa(Usuario usuario, PessoaFisica pessoa, Login login, Endereco endereco) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		java.sql.PreparedStatement stmt = null;
		try {
			connection.setAutoCommit(false);
			PessoaFisicaDAO pessoaDAO = new PessoaFisicaDAO();
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			
			usuario.setLogin(login);
			usuarioDAO.criar(usuario);
			
			enderecoDAO.salvar(endereco);
			
			Usuario buscar = new Usuario();
			buscar = usuarioDAO.buscar(login.getLogin(), login.getSenha());
			pessoa.setId_usuario(buscar.getCodigo());
			Endereco buscarEnd = new Endereco();
			buscarEnd = enderecoDAO.buscar(endereco.getCep());
			pessoa.setEndereco(buscarEnd.getCodigo());
			
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
