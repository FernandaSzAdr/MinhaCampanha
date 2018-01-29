package br.ufrpe.minhacampanha.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.ufrpe.minhacampanha.dao.CampanhaDAO;
import br.ufrpe.minhacampanha.domain.Campanha;
import br.ufrpe.minhacampanha.domain.Donativo_financeiro;
import br.ufrpe.minhacampanha.domain.Donativo_produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CampanhaBean implements Serializable{
	private Campanha campanha;
	private Donativo_produto doacaoP;
	private Donativo_financeiro doacaoF;
	private List<Campanha> campanhas;
	
	public Donativo_financeiro getDoacaoF() {
		return doacaoF;
	}
	
	public Donativo_produto getDoacaoP() {
		return doacaoP;
	}
	
	public List<Campanha> getCampanhas() {
		return campanhas;
	}
	
	public Campanha getCampanha() {
		return campanha;
	}
	
	public void setDoacaoF(Donativo_financeiro doacaoF) {
		this.doacaoF = doacaoF;
	}
	
	public void setDoacaoP(Donativo_produto doacaoP) {
		this.doacaoP = doacaoP;
	}
	
	public void setCampanhas(List<Campanha> campanhas) {
		this.campanhas = campanhas;
	}
	
	public void setCampanha(Campanha campanha) {
		this.campanha = campanha;
	}
	
	/**
	 * TODO listar todas as campanhas do sistema, vincular ao banco
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
	
	/**
	 * TODO como que vai ligar essa campanha com a instituição logada? 
	 * Será que precisa por outro tipo de Scoped? .-.	 * 
	 */
	
	public void novaDoacaoP(){
		doacaoP = new Donativo_produto();
	}
	
	public void novaDoacaoF(){
		doacaoF = new Donativo_financeiro();
	}
	
	public void novoCampanha(){
		campanha = new Campanha();
	}	
	
	public void doarFinanceiro(){
		
	}
	
	public void doarProduto(){
		
	}
}
