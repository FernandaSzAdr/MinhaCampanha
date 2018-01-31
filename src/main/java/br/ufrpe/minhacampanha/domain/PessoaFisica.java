package br.ufrpe.minhacampanha.domain;

import java.sql.Date;

@SuppressWarnings("serial")
public class PessoaFisica extends GenericDomain{
	private String primeiro_nome, medio_nome, ultimo_nome;
	private String cpf;
	private Date nascimento;
	private String telefone1, telefone2;
	private boolean ativo = true;
	private boolean anonimato = false;
	private Long endereco;
	
	public PessoaFisica(){}
	
	public PessoaFisica(String primeiro_nome, String medio_nome, String ultimo_nome, String cpf, Date nascimento,
			String telefone1, String telefone2, Long endereco) {
		this.primeiro_nome = primeiro_nome;
		this.medio_nome = medio_nome;
		this.ultimo_nome = ultimo_nome;
		this.cpf = cpf;
		this.nascimento = nascimento;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
		this.endereco = endereco;
	}

	public String getPrimeiro_nome() {
		return primeiro_nome;
	}

	public void setPrimeiro_nome(String primeiro_nome) {
		this.primeiro_nome = primeiro_nome;
	}

	public String getMedio_nome() {
		return medio_nome;
	}

	public void setMedio_nome(String medio_nome) {
		this.medio_nome = medio_nome;
	}

	public String getUltimo_nome() {
		return ultimo_nome;
	}

	public void setUltimo_nome(String ultimo_nome) {
		this.ultimo_nome = ultimo_nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
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

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public boolean isAnonimato() {
		return anonimato;
	}

	public void setAnonimato(boolean anonimato) {
		this.anonimato = anonimato;
	}

	public String getCpf() {
		return cpf;
	} 
}
