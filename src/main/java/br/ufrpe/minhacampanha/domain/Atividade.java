package br.ufrpe.minhacampanha.domain;


import java.sql.Time;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Atividade extends GenericDomain {
	private String descricao, tipo;
	private Time duracaoMedia;
	private int codigoCampanha;
	private int pessoa;
	private String data_atividade;
	
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
	public String getData_atividade() {
		return data_atividade;
	}
	public void setData_atividade(String data_atividade) {
		this.data_atividade = data_atividade;
	}

	
	
	
}
