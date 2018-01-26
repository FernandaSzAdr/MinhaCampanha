package br.ufrpe.minhacampanha.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.ufrpe.minhacampanha.domain.Campanha;
import br.ufrpe.minhacampanha.domain.Instituicao;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CampanhaInstituicaoBean implements Serializable{
	private Instituicao instituicao;
	private Campanha campanha;
	private List<Campanha> campanhas;
	
	public Campanha getCampanha() {
		return campanha;
	}
	
	public List<Campanha> getCampanhas() {
		return campanhas;
	}
	
	public Instituicao getInstituicao() {
		return instituicao;
	}
	
	public void setCampanha(Campanha campanha) {
		this.campanha = campanha;
	}
	
	public void setCampanhas(List<Campanha> campanhas) {
		this.campanhas = campanhas;
	}
	
	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}
	
	/**
	 * TODO listar todas as campanhas dessa instituição:
	 */
	@PostConstruct
	public void listar(){
		
	}
	
	public void novo(){
		campanha = new Campanha();
	}
	
	public void salvar(){
		
	}
}
