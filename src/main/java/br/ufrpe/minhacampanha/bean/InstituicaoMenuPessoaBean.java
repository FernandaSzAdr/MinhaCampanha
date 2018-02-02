package br.ufrpe.minhacampanha.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.ufrpe.minhacampanha.dao.InstituicaoDAO;
import br.ufrpe.minhacampanha.domain.Instituicao;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
/**
 * TODO COLOCAR AS INSTITUIÇÕES QUE ESTÃO RECEBENDO DOAÇÕES
 * @author fer
 */
public class InstituicaoMenuPessoaBean implements Serializable{
	private List<Instituicao> instituicoes;
	
	public List<Instituicao> getInstituicoes() {
		return instituicoes;
	}
	
	public void setInstituicoes(List<Instituicao> instituicoes) {
		this.instituicoes = instituicoes;
	}
	
	@PostConstruct
	public void listar(){
		try {
			InstituicaoDAO instituicaoDAO = new InstituicaoDAO();
			instituicoes = instituicaoDAO.listar();
		} catch (RuntimeException|SQLException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as instituições.");
			erro.printStackTrace();
		}
	}
}
