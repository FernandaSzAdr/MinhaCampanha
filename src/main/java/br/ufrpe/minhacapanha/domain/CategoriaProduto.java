package br.ufrpe.minhacapanha.domain;

public class CategoriaProduto extends GenericDomain{
	private String descricao;
	private String observacao;
	private Long id_sub_categoria;
	
	public CategoriaProduto(String descricao, String observacao) {
		this.descricao = descricao;
		this.observacao = observacao;
	}
	
	public CategoriaProduto(String descricao, String observacao, Long id_sub_categoria) {
		this.descricao = descricao;
		this.observacao = observacao;
		this.id_sub_categoria = id_sub_categoria;
	}
	public String getDescricao() {
		return descricao;
	}
	public String getObservacao() {
		return observacao;
	}
	public Long getId_sub_categoria() {
		return id_sub_categoria;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public void setId_sub_categoria(Long id_sub_categoria) {
		this.id_sub_categoria = id_sub_categoria;
	}
}
