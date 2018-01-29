package br.ufrpe.minhacampanha.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.ufrpe.minhacampanha.domain.Doacao;
import br.ufrpe.minhacampanha.domain.DoacaoProduto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class DoacoesProdutoInstiBean implements Serializable{
	private DoacaoProduto doacao;
	private List<Doacao> doacoes;
	
	public DoacaoProduto getDoacao() {
		return doacao;
	}
	
	public List<Doacao> getDoacoes() {
		return doacoes;
	}
	
	public void setDoacao(DoacaoProduto doacao) {
		this.doacao = doacao;
	}
	
	public void setDoacoes(List<Doacao> doacoes) {
		this.doacoes = doacoes;
	}
	
	@PostConstruct
	public void listar(){
		
	}
	
	public void novo(){
		doacao = new DoacaoProduto();
	}
	
	public void salvar(){
		
	}
}
