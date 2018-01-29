package br.ufrpe.minhacampanha.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.ufrpe.minhacampanha.domain.DoacaoProduto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class DoacaoProdutoPessoaBean implements Serializable{
	private DoacaoProduto doacao;
	private List<DoacaoProduto> doacoes;
	
	public DoacaoProduto getDoacao() {
		return doacao;
	}
	
	public List<DoacaoProduto> getDoacoes() {
		return doacoes;
	}
	
	public void setDoacao(DoacaoProduto doacao) {
		this.doacao = doacao;
	}
	
	public void setDoacoes(List<DoacaoProduto> doacoes) {
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
