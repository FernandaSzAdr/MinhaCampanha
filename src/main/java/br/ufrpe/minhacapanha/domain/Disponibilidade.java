package br.ufrpe.minhacapanha.domain;

import java.time.LocalDateTime;

public class Disponibilidade extends GenericDomain {
	private String responsavel;
	private LocalDateTime data;
	private LocalDateTime hora_inicio, hora_fim;
	
	/**
	 * Construtor para quando a classe for usada no Ponto_Coleta, onde não precisa ter um voluntario 
	 * vinculado ao ponto de coleta.
	 * 
	 * @param nome
	 * @param data
	 * @param hora_inicio
	 * @param hora_fim
	 */
	public Disponibilidade(String nome, LocalDateTime data, LocalDateTime hora_inicio, 
			LocalDateTime hora_fim) {
		this.responsavel = nome;
		this.data = data;
		this.hora_inicio = hora_inicio;
		this.hora_fim = hora_fim;
	}
	
	/**
	 * Construtor vinculado a classe Voluntario, onde existe uma ligação com uma Pessoa_Fisica e assim
	 * não necessita de uma string para armazenar o nome da pessoa.
	 * 
	 * @param data
	 * @param hora_inicio
	 * @param hora_fim
	 */
	public Disponibilidade(LocalDateTime data, LocalDateTime hora_inicio, LocalDateTime hora_fim) {
		this.data = data;
		this.hora_inicio = hora_inicio;
		this.hora_fim = hora_fim;
	}

	public String getNome() {
		return responsavel;
	}

	public LocalDateTime getData() {
		return data;
	}

	public LocalDateTime getHora_inicio() {
		return hora_inicio;
	}

	public LocalDateTime getHora_fim() {
		return hora_fim;
	}

	public void setNome(String nome) {
		this.responsavel = nome;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public void setHora_inicio(LocalDateTime hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public void setHora_fim(LocalDateTime hora_fim) {
		this.hora_fim = hora_fim;
	}
	
	
}
