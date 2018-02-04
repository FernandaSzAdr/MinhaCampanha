package br.ufrpe.minhacampanha.bean;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.omnifaces.util.Messages;

import com.mysql.jdbc.Connection;

import br.ufrpe.minhacampanha.dao.Instituicao_receptoraDAO;
import br.ufrpe.minhacampanha.domain.Instituicao_receptora;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
/**
 * TODO COLOCAR AS INSTITUIÇÕES QUE ESTÃO RECEBENDO DOAÇÕES
 * @author fer
 */
public class InstituicaoMenuPessoaBean implements Serializable{
	private List<Instituicao_receptora> instituicoes;
	
	public List<Instituicao_receptora> getInstituicoes() {
		return instituicoes;
	}

	public void setInstituicoes(List<Instituicao_receptora> instituicoes) {
		this.instituicoes = instituicoes;
	}

	@PostConstruct
	public void listar(){
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			
			Connection connection = (Connection) context.getExternalContext().getApplicationMap().get("connection");
			java.sql.PreparedStatement stmt = (PreparedStatement) context.getExternalContext().getApplicationMap().get("stmt");

			Instituicao_receptoraDAO instituicaoDAO = new Instituicao_receptoraDAO();
			instituicoes = instituicaoDAO.listar(connection, stmt);
		} catch (RuntimeException|SQLException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as instituições.");
			erro.printStackTrace();
		}
	}
}
