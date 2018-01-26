package br.ufrpe.minhacampanha.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.ufrpe.minhacampanha.domain.Endereco;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EnderecoPessoaBean implements Serializable{
	private Endereco endereco;
	private List<Endereco> enderecos;
	
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	public void novoEndereco(){
		endereco = new Endereco();
	}
	
	/**
	 * TODO listar todos os endereços daquela pessoa (no caso um endereço apenas)
	 */
	@PostConstruct
	public void listar(){
		
	}
	
	public void inserir(){
		
	}
}
