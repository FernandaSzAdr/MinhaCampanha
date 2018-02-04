package br.ufrpe.minhacampanha.domain;


import java.sql.Time;

/**
 * 
 * @author raiss
 *
 */
@SuppressWarnings("serial")
public class Atividade extends GenericDomain {
	private String descricao, tipo;
	private String duracaoMedia;
	private int codigoCampanha;
	private int pessoa;
	private String data_atividade;
	private String codigoS;
	
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
	public String getDuracaoMedia() {
		return duracaoMedia;
	}
	public String getCodigoS() {
		return codigoS;
	}
	public void setCodigoS(String codigoS) {
		this.codigoS = codigoS;
	}
	public void setDuracaoMedia(String duracao) {
		this.duracaoMedia = duracao;
	}
	public void setCodigoCampanha(int codigoCampanha) {
		this.codigoCampanha = codigoCampanha;
	}
	public int getCodigoCampanha() {
		return codigoCampanha;
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
