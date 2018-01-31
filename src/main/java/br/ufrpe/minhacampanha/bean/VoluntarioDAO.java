package br.ufrpe.minhacampanha.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.ufrpe.minhacampanha.dao.CampanhaDAO;
import br.ufrpe.minhacampanha.domain.Campanha;
import br.ufrpe.minhacampanha.domain.VoluntarioPessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class VoluntarioDAO implements Serializable{
	private List<Campanha> campanhas;
	private VoluntarioPessoa voluntario;

	public List<Campanha> getCampanhas() {
		return campanhas;
	}

	public void setCampanhas(List<Campanha> campanhas) {
		this.campanhas = campanhas;
	}
	
	public VoluntarioPessoa getVoluntario() {
		return voluntario;
	}

	public void setVoluntario(VoluntarioPessoa voluntario) {
		this.voluntario = voluntario;
	}
	
	public void novoVoluntario(){
		voluntario = new VoluntarioPessoa();
	}
	
	/**
	 * TODO listar também informações do voluntario, precisa de uma DAO pra isso
	 */
	@PostConstruct
	public void listar(){
		try {
			CampanhaDAO campanhaDAO = new CampanhaDAO();
			campanhas = campanhaDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao listar as campanhas existentes no sistema.");
			erro.printStackTrace();
		}
	}
	
	public void cadastrar(){
		
	}
}
