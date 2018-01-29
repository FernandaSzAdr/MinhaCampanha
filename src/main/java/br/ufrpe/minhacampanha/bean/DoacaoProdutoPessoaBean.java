package br.ufrpe.minhacampanha.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.ufrpe.minhacampanha.domain.Donativo_produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class DoacaoProdutoPessoaBean implements Serializable{
	private Donativo_produto doacao;
	private List<Donativo_produto> doacoes;
	
	public Donativo_produto getDoacao() {
		return doacao;
	}
	
	public List<Donativo_produto> getDoacoes() {
		return doacoes;
	}
	
	public void setDoacao(Donativo_produto doacao) {
		this.doacao = doacao;
	}
	
	public void setDoacoes(List<Donativo_produto> doacoes) {
		this.doacoes = doacoes;
	}
	
	@PostConstruct
	public void listar(){
		
	}
	
	public void novo(){
		doacao = new Donativo_produto();
	}
	
	public void salvar(){
		
	}
}
