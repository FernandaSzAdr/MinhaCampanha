package br.ufrpe.minhacampanha.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.ufrpe.minhacampanha.domain.Doacao;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class DoacaoPessoaBean implements Serializable{
	private Doacao doacao;
	private List<Doacao> doacoes;
	
	public Doacao getDoacao() {
		return doacao;
	}
	
	public List<Doacao> getDoacoes() {
		return doacoes;
	}
	
	public void setDoacao(Doacao doacao) {
		this.doacao = doacao;
	}
	
	public void setDoacoes(List<Doacao> doacoes) {
		this.doacoes = doacoes;
	}
	
	@PostConstruct
	public void listar(){
		
	}
	
	public void novo(){
		doacao = new Doacao();
	}
	
	public void salvar(){
		
	}
}
