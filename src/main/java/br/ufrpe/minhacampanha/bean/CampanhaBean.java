package br.ufrpe.minhacampanha.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.ufrpe.minhacampanha.domain.Campanha;

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
		
	}
	
	public void novoCampanha(){
		campanha = new Campanha();
	}
	
	
}
