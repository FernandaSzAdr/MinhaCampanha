package br.ufrpe.minhacapanha.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class PontoColeta extends GenericDomain {
	private String descricao;
	private String observacao;
	private Endereco endereco;
	
	public PontoColeta(String descricao, String observacao, Endereco endereco) {
		this.descricao = descricao;
		this.observacao = observacao;
		this.endereco = endereco;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getObservacao() {
		return observacao;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
