package br.ufrpe.minhacapanha.domain;

import java.time.LocalDate;

public class PessoaFisica extends Usuario{
	private String primeiro_nome, medio_nome, ultimo_nome;
	private String cpf, telefone;
	private LocalDate nascimento;
	private boolean ativo = true;
	private boolean anonimato = false; 

	public PessoaFisica(String email, Login login,
			String primeiro_nome, String medio_nome, String ultimo_nome, String cpf, String telefone,
			LocalDate nascimento, boolean anonimato) {
		super(email, login);
		this.primeiro_nome = primeiro_nome;
		this.medio_nome = medio_nome;
		this.ultimo_nome = ultimo_nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.nascimento = nascimento;
		this.anonimato = anonimato;
	}

	public String getPrimeiro_nome() {
		return primeiro_nome;
	}

	public String getMedio_nome() {
		return medio_nome;
	}

	public String getUltimo_nome() {
		return ultimo_nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public boolean isAnonimato() {
		return anonimato;
	}

	public void setPrimeiro_nome(String primeiro_nome) {
		this.primeiro_nome = primeiro_nome;
	}

	public void setMedio_nome(String medio_nome) {
		this.medio_nome = medio_nome;
	}

	public void setUltimo_nome(String ultimo_nome) {
		this.ultimo_nome = ultimo_nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public void setAnonimato(boolean anonimato) {
		this.anonimato = anonimato;
	}	
}
