package br.ufrpe.minhacampanha.domain;

import java.time.LocalDate;

public class Instituicao extends GenericDomain{
	private String cnpj, nome_fantasia;
	// Esse email é diferente do email de usuario. 
	private String razao_social, ramo_atuacao, nome_contato, email_geral_instituicao;
	private short telefone1, telefone2;
	private boolean ativo;
	private LocalDate data_entrada;
	
	public Instituicao( String cnpj, String nome_fantasia, String razao_social, String ramo_atuacao, String nome_contato,
			String email_geral_instituicao, short telefone1, short telefone2) {
		this.cnpj = cnpj;
		this.nome_fantasia = nome_fantasia;
		this.razao_social = razao_social;
		this.ramo_atuacao = ramo_atuacao;
		this.nome_contato = nome_contato;
		this.email_geral_instituicao = email_geral_instituicao;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
		this.data_entrada = LocalDate.now();
	}

	public String getCnpj() {
		return cnpj;
	}


	public String getNome_fantasia() {
		return nome_fantasia;
	}

	public String getRazao_social() {
		return razao_social;
	}

	public String getRamo_atuacao() {
		return ramo_atuacao;
	}

	public String getNome_contato() {
		return nome_contato;
	}

	public void setNome_contato(String nome_contato) {
		this.nome_contato = nome_contato;
	}

	public String getEmail_geral_instituicao() {
		return email_geral_instituicao;
	}

	public void setEmail_geral_instituicao(String email_geral_instituicao) {
		this.email_geral_instituicao = email_geral_instituicao;
	}

	public short getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(short telefone1) {
		this.telefone1 = telefone1;
	}

	public short getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(short telefone2) {
		this.telefone2 = telefone2;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public LocalDate getData_entrada() {
		return data_entrada;
	}
	
}
