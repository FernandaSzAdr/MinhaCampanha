package br.ufrpe.minhacampanha.domain;

import java.sql.Date;
import java.sql.Time;

@SuppressWarnings("serial")
public class Atividade extends GenericDomain {
	private String descricao, tipo;
	private Time duracaoMedia;
	private int codigoCampanha;
	private int pessoa;
	private Date pessoa_atividade;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Time getDuracaoMedia() {
		return duracaoMedia;
	}
	public void setDuracaoMedia(Time duracao) {
		this.duracaoMedia = duracao;
	}
	public long getCodigoCampanha() {
		return codigoCampanha;
	}
	public void setCodigoCampanha(int codigoCampanha) {
		this.codigoCampanha = codigoCampanha;
	}
	public int getPessoa() {
		return pessoa;
	}
	public void setPessoa(int pessoa) {
		this.pessoa = pessoa;
	}
	public Date getPessoa_atividade() {
		return pessoa_atividade;
	}
	public void setPessoa_atividade(Date pessoa_atividade) {
		this.pessoa_atividade = pessoa_atividade;
	}
	
}
