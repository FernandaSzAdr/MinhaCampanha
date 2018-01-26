package br.ufrpe.minhacampanha.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.ufrpe.minhacampanha.domain.Endereco;

@ManagedBean
@ViewScoped
public class EnderecoInstituicaoBean implements Serializable{
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
	 * TODO listar todos os endereços daquela instituição
	 */
	@PostConstruct
	public void listar(){
		
	}
	
	/**
	 * TODO adicionar mais um endereço naquela instituição
	 */
	public void inserir(){
		
	}
}
