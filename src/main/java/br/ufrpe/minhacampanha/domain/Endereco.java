package br.ufrpe.minhacampanha.domain;

public class Endereco extends GenericDomain{
	private String cep, nome, numero, cidade, bairro, ponto_ref, tipo_logradoro;
	private char estado;
	
	public Endereco() {
	}

	public Endereco(String cep, String nome, String numero, String cidade, String bairro, String ponto_ref,
			String tipo_logradoro, char estado) {
		this.cep = cep;
		this.nome = nome;
		this.numero = numero;
		this.cidade = cidade;
		this.bairro = bairro;
		this.ponto_ref = ponto_ref;
		this.tipo_logradoro = tipo_logradoro;
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getPonto_ref() {
		return ponto_ref;
	}

	public void setPonto_ref(String ponto_ref) {
		this.ponto_ref = ponto_ref;
	}

	public String getTipo_logradoro() {
		return tipo_logradoro;
	}

	public void setTipo_logradoro(String tipo_logradoro) {
		this.tipo_logradoro = tipo_logradoro;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}
}
