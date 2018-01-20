package br.ufrpe.minhacapanha.domain;

import java.time.LocalDate;

import br.ufrpe.minhacampanha.enumeracao.SituacaoItem;

public class Item extends GenericDomain {
	private String descricao;
	private String marca;
	private String codigo_barra; 
	private LocalDate validade;
	private SituacaoItem situacao;
	private int qtd;
	
	public Item(String descricao, String marca, String codigo_barra, LocalDate validade, SituacaoItem situacao,
			int qtd) {
		this.descricao = descricao;
		this.marca = marca;
		this.codigo_barra = codigo_barra;
		this.validade = validade;
		this.situacao = situacao;
		this.qtd = qtd;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getMarca() {
		return marca;
	}

	public String getCodigo_barra() {
		return codigo_barra;
	}

	public LocalDate getValidade() {
		return validade;
	}

	public SituacaoItem getSituacao() {
		return situacao;
	}

	public int getQtd() {
		return qtd;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setCodigo_barra(String codigo_barra) {
		this.codigo_barra = codigo_barra;
	}

	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}

	public void setSituacao(SituacaoItem situacao) {
		this.situacao = situacao;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}	
}
