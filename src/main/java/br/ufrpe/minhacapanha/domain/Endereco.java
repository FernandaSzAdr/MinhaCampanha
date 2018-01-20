package br.ufrpe.minhacapanha.domain;

public class Endereco extends GenericDomain {
	private String nome, cidade, bairro, estado;
	private String cep;
	private String ponto_referencia, comple_1, comple_2;
	private String tipo_logradouro;
	private short numero;

	public Endereco() {
		nome = cidade = bairro = estado = "";
		cep = ponto_referencia = comple_1 = comple_2 = "";
		tipo_logradouro = "";
		numero = 0;
	}

	public Endereco(String nome, String cidade, String bairro, String estado, String cep, String ponto_referencia,
			String comple_1, String comple_2, String tipo_logradouro, short numero) {
		this.nome = nome;
		this.cidade = cidade;
		this.bairro = bairro;
		this.estado = estado;
		this.cep = cep;
		this.ponto_referencia = ponto_referencia;
		this.comple_1 = comple_1;
		this.comple_2 = comple_2;
		this.tipo_logradouro = tipo_logradouro;
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getPonto_referencia() {
		return ponto_referencia;
	}

	public void setPonto_referencia(String ponto_referencia) {
		this.ponto_referencia = ponto_referencia;
	}

	public String getComple_1() {
		return comple_1;
	}

	public void setComple_1(String comple_1) {
		this.comple_1 = comple_1;
	}

	public String getComple_2() {
		return comple_2;
	}

	public void setComple_2(String comple_2) {
		this.comple_2 = comple_2;
	}

	public String getTipo_logradouro() {
		return tipo_logradouro;
	}

	public void setTipo_logradouro(String tipo_logradouro) {
		this.tipo_logradouro = tipo_logradouro;
	}

	public short getNumero() {
		return numero;
	}

	public void setNumero(short numero) {
		this.numero = numero;
	}
	
	

}
