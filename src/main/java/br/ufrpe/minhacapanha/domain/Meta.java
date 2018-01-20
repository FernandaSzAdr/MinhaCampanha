package br.ufrpe.minhacapanha.domain;

import java.time.LocalDateTime;

import br.ufrpe.minhacampanha.enumeracao.Situacao;

public class Meta extends GenericDomain {
	private float valor;
	private LocalDateTime data_inicio, data_fim;
	private Situacao situacao;
	
	public Meta(float valor, LocalDateTime data_inicio, LocalDateTime data_fim) {
		this.valor = valor;
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;
	}

	public Meta(){
		
	}
	public float getValor() {
		return valor;
	}

	public LocalDateTime getData_inicio() {
		return data_inicio;
	}

	public LocalDateTime getData_fim() {
		return data_fim;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public void setData_inicio(LocalDateTime data_inicio) {
		this.data_inicio = data_inicio;
	}

	public void setData_fim(LocalDateTime data_fim) {
		this.data_fim = data_fim;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	
	
}
