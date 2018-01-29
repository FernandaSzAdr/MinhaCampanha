package br.ufrpe.minhacampanha.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.omnifaces.util.Messages;

import br.ufrpe.minhacampanha.dao.InstituicaoDAO;
import br.ufrpe.minhacampanha.domain.Instituicao;



public class TestConnection {

	@Test
	public void listar() throws SQLException{
		List<Instituicao> instituicoes;
		try {
			InstituicaoDAO instituicaoDAO = new InstituicaoDAO();
			instituicoes = instituicaoDAO.listar();
			System.out.println(instituicoes);
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as instituições.");
			erro.printStackTrace();
		}
	}
}
