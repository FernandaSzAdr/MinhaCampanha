package br.ufrpe.minhacampanha.domain;

import java.time.LocalDate;

public class Campanha extends GenericDomain{
	private LocalDate data_inicio, data_fim;
	private String publico_alvo, nome;
	private short status_campanha_enum;
	private float qtd_valor_necessario, qtd_valor_atual;
	private int qtd_donativo_necessario, qtd_donativo_atual;
	private boolean ativo = true;
	
	public Campanha(){}
	
	public Campanha(LocalDate data_incio, LocalDate data_fim, String publico_alvo, String nome, short status,
			float qtd_valor_necessario) {
		this.data_inicio = data_incio;
		this.data_fim = data_fim;
		this.publico_alvo = publico_alvo;
		this.nome = nome;
		this.status_campanha_enum = status;
		this.qtd_valor_necessario = qtd_valor_necessario;
	}

	public Campanha(LocalDate data_incio, LocalDate data_fim, String publico_alvo, String nome, short status,
			int qtd_donativo_necessario) {
		this.data_inicio = data_incio;
		this.data_fim = data_fim;
		this.publico_alvo = publico_alvo;
		this.nome = nome;
		this.status_campanha_enum = status;
		this.qtd_donativo_necessario = qtd_donativo_necessario;
	}

	public LocalDate getData_incio() {
		return data_inicio;
	}

	public LocalDate getData_fim() {
		return data_fim;
	}

	public String getPublico_alvo() {
		return publico_alvo;
	}

	public String getNome() {
		return nome;
	}

	public short getStatus() {
		return status_campanha_enum;
	}

	public float getQtd_valor_necessario() {
		return qtd_valor_necessario;
	}

	public float getQtd_valor_atual() {
		return qtd_valor_atual;
	}

	public int getQtd_donativo_necessario() {
		return qtd_donativo_necessario;
	}

	public int getQtd_donativo_atual() {
		return qtd_donativo_atual;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setData_fim(LocalDate data_fim) {
		this.data_fim = data_fim;
	}

	public void setPublico_alvo(String publico_alvo) {
		this.publico_alvo = publico_alvo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setStatus(short status) {
		this.status_campanha_enum = status;
	}

	public void setQtd_valor_necessario(float qtd_valor_necessario) {
		this.qtd_valor_necessario = qtd_valor_necessario;
	}

	public void setQtd_valor_atual(float qtd_valor_atual) {
		this.qtd_valor_atual = qtd_valor_atual;
	}

	public void setQtd_donativo_necessario(int qtd_donativo_necessario) {
		this.qtd_donativo_necessario = qtd_donativo_necessario;
	}

	public void setQtd_donativo_atual(int qtd_donativo_atual) {
		this.qtd_donativo_atual = qtd_donativo_atual;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}	
}
