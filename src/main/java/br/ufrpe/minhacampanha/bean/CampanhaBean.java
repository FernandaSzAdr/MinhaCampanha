package br.ufrpe.minhacampanha.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.ufrpe.minhacampanha.domain.Campanha;
import br.ufrpe.minhacampanha.domain.DoacaoFinanceira;
import br.ufrpe.minhacampanha.domain.DoacaoProduto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CampanhaBean implements Serializable{
	private Campanha campanha;
	private DoacaoProduto doacaoP;
	private DoacaoFinanceira doacaoF;
	private List<Campanha> campanhas;
	
	public DoacaoFinanceira getDoacaoF() {
		return doacaoF;
	}
	
	public DoacaoProduto getDoacaoP() {
		return doacaoP;
	}
	
	public List<Campanha> getCampanhas() {
		return campanhas;
	}
	
	public Campanha getCampanha() {
		return campanha;
	}
	
	public void setDoacaoF(DoacaoFinanceira doacaoF) {
		this.doacaoF = doacaoF;
	}
	
	public void setDoacaoP(DoacaoProduto doacaoP) {
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
		doacaoP = new DoacaoProduto();
	}
	
	public void novaDoacaoF(){
		doacaoF = new DoacaoFinanceira();
	}
	
	public void novoCampanha(){
		campanha = new Campanha();
	}	
	
	public void doarFinanceiro(){
		
	}
	
	public void doarProduto(){
		
	}
}
