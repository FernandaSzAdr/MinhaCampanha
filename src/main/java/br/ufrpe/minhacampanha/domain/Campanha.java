package br.ufrpe.minhacampanha.domain;

import java.time.LocalDate;

@SuppressWarnings("serial")
public class Campanha extends GenericDomain{
	private LocalDate data_inicio, data_fim;
	private String publico_alvo, nome;
	private String status_campanha_enum;
	private String id_S;
	private float qtd_valor_necessario, qtd_valor_atual;
	private int qtd_donativo_necessario, qtd_donativo_atual;
	
	public Campanha(){}

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

	public LocalDate getData_inicio() {
		return data_inicio;
	}
	
	public String getStatus_campanha_enum() {
		return status_campanha_enum;
	}
	
	public String getId_S() {
		return id_S;
	}

	public void setId_S(String id_S) {
		this.id_S = id_S;
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
	
	public void setData_inicio(LocalDate data_inicio) {
		this.data_inicio = data_inicio;
	}
	
	public void setStatus_campanha_enum(String status_campanha_enum) {
		this.status_campanha_enum = status_campanha_enum;
	}
}
