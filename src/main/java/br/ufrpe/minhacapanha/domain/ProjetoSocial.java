package br.ufrpe.minhacapanha.domain;

import java.time.LocalDate;
import java.util.ArrayList;

public class ProjetoSocial extends GenericDomain {
	private String tipo, nome, descricao, objetivo;
	private LocalDate data_inicio, data_fim;
	
	public ProjetoSocial(String tipo, String nome, String descricao, String objetivo, LocalDate data_inicio,
			LocalDate data_fim) {
		this.tipo = tipo;
		this.nome = nome;
		this.descricao = descricao;
		this.objetivo = objetivo;
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;
	}

	public ProjetoSocial(String tipo, String nome, String descricao, String objetivo, LocalDate data_inicio) {
		this.tipo = tipo;
		this.nome = nome;
		this.descricao = descricao;
		this.objetivo = objetivo;
		this.data_inicio = data_inicio;
	}

	public String getTipo() {
		return tipo;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public LocalDate getData_inicio() {
		return data_inicio;
	}

	public LocalDate getData_fim() {
		return data_fim;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public void setData_fim(LocalDate data_fim) {
		this.data_fim = data_fim;
	}
}
