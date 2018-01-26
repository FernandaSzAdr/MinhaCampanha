package br.ufrpe.minhacampanha.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.ufrpe.minhacampanha.domain.Campanha;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CampanhaBean implements Serializable{
	private Campanha campanha;
	private List<Campanha> campanhas;
	
	public List<Campanha> getCampanhas() {
		return campanhas;
	}
	
	public Campanha getCampanha() {
		return campanha;
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
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao listar as campanhas existentes no sistema.");
			erro.printStackTrace();
		}
	}
	
	/**
	 * TODO como que vai ligar essa campanha com a instituição logada? 
	 * Será que precisa por outro tipo de Scoped? .-.	 * 
	 */
	public void novoCampanha(){
		campanha = new Campanha();
	}	
}
