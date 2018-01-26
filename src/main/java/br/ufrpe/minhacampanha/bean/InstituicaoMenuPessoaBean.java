package br.ufrpe.minhacampanha.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.ufrpe.minhacampanha.domain.Instituicao;

@ManagedBean
@ViewScoped
/**
 * TODO COLOCAR AS INSTITUIÇÕES QUE ESTÃO RECEBENDO DOAÇÕES
 * @author fer
 */
public class InstituicaoMenuPessoaBean implements Serializable{
	private List<Instituicao> instituicoes;
	
	public List<Instituicao> getInstituicoes() {
		return instituicoes;
	}
	
	public void setInstituicoes(List<Instituicao> instituicoes) {
		this.instituicoes = instituicoes;
	}
	
	@PostConstruct
	public void listar(){
		
	}
}
