package br.ufrpe.minhacapanha.domain;

import java.time.LocalDate;

public class Administrador extends GenericDomain{
	private String cpf, nome;
	private LocalDate data_inicio_atividade, data_fim_atividade;
	private LocalDate data_nascimento;
	
	public Administrador(String cpf, String nome, LocalDate data_inicio_atividade, LocalDate data_nascimento) {
		this.cpf = cpf;
		this.nome = nome;
		this.data_inicio_atividade = data_inicio_atividade;
		this.data_nascimento = data_nascimento;
	}

	public Administrador(String cpf, String nome, LocalDate data_nascimento) {
		this.cpf = cpf;
		this.nome = nome;
		this.data_nascimento = data_nascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getData_inicio_atividade() {
		return data_inicio_atividade;
	}

	public LocalDate getData_fim_atividade() {
		return data_fim_atividade;
	}

	public LocalDate getData_nascimento() {
		return data_nascimento;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setData_inicio_atividade(LocalDate data_inicio_atividade) {
		this.data_inicio_atividade = data_inicio_atividade;
	}

	public void setData_fim_atividade(LocalDate data_fim_atividade) {
		this.data_fim_atividade = data_fim_atividade;
	}
}
