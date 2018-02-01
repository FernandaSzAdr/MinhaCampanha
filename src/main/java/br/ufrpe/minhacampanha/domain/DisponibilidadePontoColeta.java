package br.ufrpe.minhacampanha.domain;

import java.time.LocalDate;
import java.time.LocalTime;

@SuppressWarnings("serial")
public class DisponibilidadePontoColeta extends GenericDomain {
	private String responsavel;
	private LocalDate data;
	private LocalTime hora_inicio, hora_fim;
	private Long pontocoleta;
	
	public Long getPontoColeta() {
		return pontocoleta;
	}
	
	public String getNome() {
		return responsavel;
	}

	public LocalDate getData() {
		return data;
	}

	public LocalTime getHora_inicio() {
		return hora_inicio;
	}

	public LocalTime getHora_fim() {
		return hora_fim;
	}

	public void setNome(String nome) {
		this.responsavel = nome;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public void setHora_inicio(LocalTime hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public void setHora_fim(LocalTime hora_fim) {
		this.hora_fim = hora_fim;
	}
}
