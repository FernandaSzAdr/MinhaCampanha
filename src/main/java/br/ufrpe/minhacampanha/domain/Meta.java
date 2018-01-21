package br.ufrpe.minhacampanha.domain;

import java.time.LocalDate;


public class Meta extends GenericDomain {
	private float valor;
	private LocalDate data_inicio, data_fim;
	private short situacao_meta_enum;
	private Long campanha;
	
	public Meta(float valor, LocalDate data_inicio, LocalDate data_fim, Long campanha) {
		this.valor = valor;
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;
		this.campanha = campanha;
	}

	public Meta(){
		
	}
	public float getValor() {
		return valor;
	}

	public LocalDate getData_inicio() {
		return data_inicio;
	}

	public LocalDate getData_fim() {
		return data_fim;
	}

	public short getSituacao() {
		return situacao_meta_enum;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public void setData_inicio(LocalDate data_inicio) {
		this.data_inicio = data_inicio;
	}

	public void setData_fim(LocalDate data_fim) {
		this.data_fim = data_fim;
	}

	public void setSituacao(short situacao) {
		this.situacao_meta_enum = situacao;
	}
	
	
}
