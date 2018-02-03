package br.ufrpe.minhacampanha.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.omnifaces.util.Messages;

import br.ufrpe.minhacampanha.dao.AtividadeDAO;
import br.ufrpe.minhacampanha.domain.Atividade;
import br.ufrpe.minhacampanha.domain.Instituicao;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class AtividadeBean implements Serializable{
	private Atividade atividade;
	private List<Atividade> atividades;
	
	public Atividade getAtividade() {
		return atividade;
	}
	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}
	public List<Atividade> getAtividades() {
		return atividades;
	}
	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}
	
	public void novaAtividade(){
		atividade = new Atividade();
	}
	
	@PostConstruct
	public void listar(){
		try {
			AtividadeDAO atividadeDAO = new AtividadeDAO();
			
			FacesContext context = FacesContext.getCurrentInstance();
			Instituicao instituicao = (Instituicao) context.getExternalContext().getApplicationMap().get("instituicao");
			
			atividades = atividadeDAO.listar(instituicao.getCodigo());
		} catch (SQLException e) {
			Messages.addGlobalFatal("Ocorreu um erro ao tentar listar as atividades dessa instituição");
		}
	}
	
	public void salvar(){
		
	}
}
