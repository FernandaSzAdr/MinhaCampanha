package br.ufrpe.minhacapanha.domain;

import java.sql.Date;
import java.time.LocalDateTime;

public class Atividade extends GenericDomain {
	private String descricao, tipo;
	private LocalDateTime duracao;
	public String getDescricao() {
		return descricao;
	}
	public String getTipo() {
		return tipo;
	}
	public LocalDateTime getDuracao() {
		return duracao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setDuracao(LocalDateTime duracao) {
		this.duracao = duracao;
	}
	public long getCodigoCampanha() {
		// TODO Auto-generated method stub
		return 0;
	}
	public Date getDuracaoMedia() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setCodigoCampanha(long long1) {
		// TODO Auto-generated method stub
		
	}
	public void setDuracaoMedia(Date date) {
		// TODO Auto-generated method stub
		
	}
	
	
}
