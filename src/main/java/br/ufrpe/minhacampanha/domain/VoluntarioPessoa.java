package br.ufrpe.minhacampanha.domain;

import java.time.LocalDate;

/**
 * Essa classe, se refere as pessoas que s�o voluntarias de um projeto ou campanha,
 * mas que n�o possuem cadastro no sistema.
 * 
 * @author Fernanda
 *
 */
@SuppressWarnings("serial")
public class VoluntarioPessoa extends GenericDomain {
	private String cpf;
	private String nome;
	private LocalDate data_admisao;
	private ProjetoSocial projeto;
	
	public VoluntarioPessoa(){}
	
	public VoluntarioPessoa(String cpf, String nome, LocalDate data_admisao, ProjetoSocial projeto) {
		this.cpf = cpf;
		this.nome = nome;
		this.data_admisao = data_admisao;
		this.projeto = projeto;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getData_admisao() {
		return data_admisao;
	}

	public ProjetoSocial getProjeto() {
		return projeto;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setData_admisao(LocalDate data_admisao) {
		this.data_admisao = data_admisao;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setProjeto(ProjetoSocial projeto) {
		this.projeto = projeto;
	}
	
}