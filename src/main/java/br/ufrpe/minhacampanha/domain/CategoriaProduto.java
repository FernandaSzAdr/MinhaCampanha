package br.ufrpe.minhacampanha.domain;

@SuppressWarnings("serial")
public class CategoriaProduto extends GenericDomain{
	private String id_S;
	private String descricao;
	private String observacao;
	private int id_sub_categoria;

	public CategoriaProduto() {}
	
	public String getDescricao() {
		return descricao;
	}
	public String getObservacao() {
		return observacao;
	}
	public int getId_sub_categoria() {
		return id_sub_categoria;
	}
	public String getId_S() {
		return id_S;
	}

	public void setId_S(String id_S) {
		this.id_S = id_S;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public void setId_sub_categoria(int id_sub_categoria) {
		this.id_sub_categoria = id_sub_categoria;
	}
}
