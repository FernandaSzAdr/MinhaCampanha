package br.ufrpe.minhacampanha.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class PontoColeta extends GenericDomain {
	private String descricao;
	private String observacao;
	private Long endereco;
	
	public PontoColeta(String descricao, String observacao, Long endereco) {
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

	public Long getEndereco() {
		return endereco;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public void setEndereco(Long endereco) {
		this.endereco = endereco;
	}
}
