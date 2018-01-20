package br.ufrpe.minhacapanha.domain;

import java.time.LocalDate;

public class DoacaoProtocolo extends GenericDomain{
	private String numero_protocolo;
	private String descricao;
	private String observacao;
	private LocalDate data_geracao;
	
	public DoacaoProtocolo(String numero_protocolo, String descricao, String observacao, LocalDate data_geracao) {
		this.numero_protocolo = numero_protocolo;
		this.descricao = descricao;
		this.observacao = observacao;
		this.data_geracao = data_geracao;
	}

	public DoacaoProtocolo(String numero_protocolo, String descricao, String observacao) {
		this.numero_protocolo = numero_protocolo;
		this.descricao = descricao;
		this.observacao = observacao;
	}

	public String getNumero_protocolo() {
		return numero_protocolo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getObservacao() {
		return observacao;
	}

	public LocalDate getData_geracao() {
		return data_geracao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public void setData_geracao(LocalDate data_geracao) {
		this.data_geracao = data_geracao;
	}
}
