package br.ufrpe.minhacampanha.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.ufrpe.minhacampanha.dao.Instituicao_receptoraDAO;
import br.ufrpe.minhacampanha.domain.Instituicao_receptora;
import br.ufrpe.minhacampanha.util.ConnectionFactory;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
/**
 * TODO COLOCAR AS INSTITUIÇÕES QUE ESTÃO RECEBENDO DOAÇÕES
 * @author fer
 */
public class InstituicaoMenuPessoaBean implements Serializable{
	private List<Instituicao_receptora> instituicoes;
	private Connection connection = null;
	
	public List<Instituicao_receptora> getInstituicoes() {
		return instituicoes;
	}

	public void setInstituicoes(List<Instituicao_receptora> instituicoes) {
		this.instituicoes = instituicoes;
	}

	@PostConstruct
	public void listar(){
		try {
			connection = ConnectionFactory.getConnection();
			
			Instituicao_receptoraDAO instituicaoDAO = new Instituicao_receptoraDAO();
			instituicoes = instituicaoDAO.listar(connection);
		} catch (RuntimeException|SQLException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as instituições.");
			erro.printStackTrace();
		}finally {
			ConnectionFactory.closeConnection(connection);
		}
	}
}
