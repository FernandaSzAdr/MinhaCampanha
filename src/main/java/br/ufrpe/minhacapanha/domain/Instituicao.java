package br.ufrpe.minhacapanha.domain;

public class Instituicao extends Usuario{
	private String cnpj, nome_fantasia;
	private String razao_social, ramo_atuacao, nome_contato;
	private short telefone1, telefone2;
	private boolean ativo;
	
	public Instituicao(String email, Login login,
			String cnpj, String nome_fantasia, String razao_social, String ramo_atuacao, String nome_contato,
			short telefone1, short telefone2, boolean ativo) {
		super(email, login);
		this.cnpj = cnpj;
		this.nome_fantasia = nome_fantasia;
		this.razao_social = razao_social;
		this.ramo_atuacao = ramo_atuacao;
		this.nome_contato = nome_contato;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
		this.ativo = ativo;
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

	public short getTelefone1() {
		return telefone1;
	}

	public short getTelefone2() {
		return telefone2;
	}

	public boolean isAtivo() {
		return ativo;
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

	public void setNome_contato(String nome_contato) {
		this.nome_contato = nome_contato;
	}

	public void setTelefone1(short telefone1) {
		this.telefone1 = telefone1;
	}

	public void setTelefone2(short telefone2) {
		this.telefone2 = telefone2;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
}
