package br.ufrpe.minhacapanha.domain;

public class Banco extends GenericDomain {
	private String nome;
	private String cnpj;
	private String razao_social;
	private int codigo_banco;
	
	public Banco(String nome, String cnpj, String razao_social, int codigo_banco) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.razao_social = razao_social;
		this.codigo_banco = codigo_banco;
	}

	public String getNome() {
		return nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getRazao_social() {
		return razao_social;
	}

	public int getCodigo_banco() {
		return codigo_banco;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}
}
