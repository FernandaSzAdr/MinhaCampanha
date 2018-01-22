package br.ufrpe.minhacampanha.domain;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

public class Atividade extends GenericDomain {
	private String descricao, tipo;
	private Time duracaoMedia;
	private long codigoCampanha;
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
	public void setCodigoCampanha(long codigoCampanha) {
		this.codigoCampanha = codigoCampanha;
	}
	
	
	
}
