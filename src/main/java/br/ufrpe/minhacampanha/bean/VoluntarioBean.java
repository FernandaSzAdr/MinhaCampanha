package br.ufrpe.minhacampanha.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.omnifaces.util.Messages;

import br.ufrpe.minhacampanha.dao.CampanhaDAO;
import br.ufrpe.minhacampanha.dao.PessoaFisicaVoluntarioDAO;
import br.ufrpe.minhacampanha.domain.Campanha;
import br.ufrpe.minhacampanha.domain.DisponibilidadePessoaFisica;
import br.ufrpe.minhacampanha.domain.PessoaFisica;
import br.ufrpe.minhacampanha.domain.PessoaFisicaVoluntario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class VoluntarioBean implements Serializable{
	private List<Campanha> campanhas;
	private PessoaFisicaVoluntario voluntario;
	private DisponibilidadePessoaFisica disponibilidade;

	public List<Campanha> getCampanhas() {
		return campanhas;
	}

	public void setCampanhas(List<Campanha> campanhas) {
		this.campanhas = campanhas;
	}
	
	public PessoaFisicaVoluntario getVoluntario() {
		return voluntario;
	}

	public void setVoluntario(PessoaFisicaVoluntario voluntario) {
		this.voluntario = voluntario;
	}
	
	public DisponibilidadePessoaFisica getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(DisponibilidadePessoaFisica disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public void novoVoluntario(){
		voluntario = new PessoaFisicaVoluntario();
		disponibilidade = new DisponibilidadePessoaFisica();
	}
	
	/**
	 * TODO listar também informações do voluntario, precisa de uma DAO pra isso
	 */
	@PostConstruct
	public void listar(){
		try {
			CampanhaDAO campanhaDAO = new CampanhaDAO();
			campanhas = campanhaDAO.listar();
		} catch (RuntimeException|SQLException erro) {
			Messages.addGlobalError("Ocorreu um erro ao listar as campanhas existentes no sistema.");
			erro.printStackTrace();
		}
	}
	
	public void cadastrar(){
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			PessoaFisica pessoa = (PessoaFisica) context.getExternalContext().getApplicationMap().get("pessoa");
			
			voluntario.setPessoa(pessoa.getCodigo());
			
			PessoaFisicaVoluntarioDAO voluntarioDAO = new PessoaFisicaVoluntarioDAO();
			voluntarioDAO.criar(voluntario);
		} catch (RuntimeException|SQLException e) {
			Messages.addGlobalError("Erro ao tentar se voluntariar!");
		}
	}
}
