package br.ufrpe.minhacampanha.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 
 * @author raiss
 *
 */
@SuppressWarnings("serial")
public class Instituicao extends GenericDomain{
	private String cnpj, nome_fantasia;
	// Esse email � diferente do email de usuario. 
	private String razao_social, ramo_atuacao, nome_contato, email_geral_instituicao;
	private String telefone1, telefone2;
	private LocalDate data_entrada;
	private String tipo_instituicao;
	
	public Instituicao() {
		data_entrada = LocalDate.now();
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String text = data_entrada.format(formatters);
	    data_entrada = LocalDate.parse(text, formatters);
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

	public void setData_entrada(LocalDate data_entrada) {
		this.data_entrada = data_entrada;
	}
	
	public String getTipo_instituicao() {
		return tipo_instituicao;
	}

	public void setTipo_instituicao(String tipo_instituicao) {
		this.tipo_instituicao = tipo_instituicao;
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


	public LocalDate getData_entrada() {
		return data_entrada;
	}
	
}
