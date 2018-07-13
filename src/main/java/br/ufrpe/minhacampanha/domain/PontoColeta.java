package br.ufrpe.minhacampanha.domain;

@SuppressWarnings("serial")
public class PontoColeta extends GenericDomain {
	private String descricao;
	private String id_S;
	private int endereco;
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getId_S() {
		return id_S;
	}
	public void setId_S(String id_S) {
		this.id_S = id_S;
	}
	public int getEndereco() {
		return endereco;
	}
	public void setEndereco(int endereco) {
		this.endereco = endereco;
	}
}
