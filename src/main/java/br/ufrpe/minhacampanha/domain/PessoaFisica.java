package br.ufrpe.minhacampanha.domain;

import java.time.LocalDate;

@SuppressWarnings("serial")
public class PessoaFisica extends GenericDomain{
	private String primeiro_nome, medio_nome, ultimo_nome;
	private String cpf;
	private LocalDate nascimento;
	private String telefone1, telefone2;
	private boolean ativo = true;
	private int anonimato;
	private int id_endereco;
	private int id_usuario;
	private String tipo_pessoa;
	
	public PessoaFisica(){}

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

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
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

	public int isAnonimato() {
		return anonimato;
	}

	public void setAnonimato(int anonimato) {
		this.anonimato = anonimato;
	}

	public String getCpf() {
		return cpf;
	}

	public String getTipo_pessoa() {
		return tipo_pessoa;
	}

	public void setTipo_pessoa(String tipo_pessoa) {
		this.tipo_pessoa = tipo_pessoa;
	}

	public int getEndereco() {
		return id_endereco;
	}

	public void setEndereco(int endereco) {
		this.id_endereco = endereco;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	} 
}
