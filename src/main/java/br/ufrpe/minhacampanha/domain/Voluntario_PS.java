package br.ufrpe.minhacampanha.domain;

import java.time.LocalDate;

public class Voluntario_PS extends GenericDomain{
	private String cpf;
	private String nome;
	private LocalDate data_admissao;
	private int idProjeto;
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getData_admissao() {
		return data_admissao;
	}
	public void setData_admissao(LocalDate data_admissao) {
		this.data_admissao = data_admissao;
	}
	public int getIdProjeto() {
		return idProjeto;
	}
	public void setIdProjeto(int idProjeto) {
		this.idProjeto = idProjeto;
	}
	
	
}
