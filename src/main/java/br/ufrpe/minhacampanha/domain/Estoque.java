package br.ufrpe.minhacampanha.domain;

import java.time.LocalDate;

public class Estoque extends GenericDomain{
	private Long id_adm;
	private String descricao;
	private LocalDate data_ultima_entrada;
	
	public Estoque(Long id_adm, String descricao) {
		this.id_adm = id_adm;
		this.descricao = descricao;
	}

	public Long getId_adm() {
		return id_adm;
	}

	public void setId_adm(Long id_adm) {
		this.id_adm = id_adm;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getData_ultima_entrada() {
		return data_ultima_entrada;
	}

	public void setData_ultima_entrada(LocalDate data_ultima_entrada) {
		this.data_ultima_entrada = data_ultima_entrada;
	}
}
