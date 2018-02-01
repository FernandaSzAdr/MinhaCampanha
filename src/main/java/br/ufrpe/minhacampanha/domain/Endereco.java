package br.ufrpe.minhacampanha.domain;

@SuppressWarnings("serial")
public class Endereco extends GenericDomain{
	private String cep, nome, numero, cidade, bairro, ponto_ref, tipo_logradoro;
	private String estado;
	
	public Endereco() {
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
