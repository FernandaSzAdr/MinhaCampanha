package br.ufrpe.minhacampanha.domain;

import java.sql.Date;
import java.time.LocalDate;

public class Instituicao extends GenericDomain{
	private String cnpj, nome_fantasia;
	// Esse email é diferente do email de usuario. 
	private String razao_social, ramo_atuacao, nome_contato, email_geral_instituicao;
	private String telefone1, telefone2;
	private Date data_entrada;
	private long id_usuario;
	
	public long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setNome_fantasia(String nome_fantasia) {
		this.nome_fantasia = nome_fantasia;
	}

	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}

	public void setRamo_atuacao(String ramo_atuacao) {
		this.ramo_atuacao = ramo_atuacao;
	}

	public void setData_entrada(Date data_entrada) {
		this.data_entrada = data_entrada;
	}

	public Instituicao( String cnpj, String nome_fantasia, String razao_social, String ramo_atuacao, String nome_contato,
			String email_geral_instituicao, String telefone1, String telefone2, Date data_entrada) {
		this.cnpj = cnpj;
		this.nome_fantasia = nome_fantasia;
		this.razao_social = razao_social;
		this.ramo_atuacao = ramo_atuacao;
		this.nome_contato = nome_contato;
		this.email_geral_instituicao = email_geral_instituicao;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
		this.data_entrada = data_entrada;
	}

	public Instituicao() {
		// TODO Auto-generated constructor stub
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

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}


	public Date getData_entrada() {
		return data_entrada;
	}
	
}
