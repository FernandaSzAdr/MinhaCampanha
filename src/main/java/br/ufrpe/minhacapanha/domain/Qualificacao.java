package br.ufrpe.minhacapanha.domain;

import java.time.LocalDate;

public class Qualificacao extends GenericDomain {
	private LocalDate data_obtencao;
	private String descricao, grau;
	
	public Qualificacao(LocalDate data_obtencao, String descricao, String grau) {
		this.data_obtencao = data_obtencao;
		this.descricao = descricao;
		this.grau = grau;
	}

	public LocalDate getData_obtencao() {
		return data_obtencao;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getGrau() {
		return grau;
	}
}
