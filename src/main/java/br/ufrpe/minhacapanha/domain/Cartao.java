package br.ufrpe.minhacapanha.domain;
import java.time.LocalDateTime;

public class Cartao extends GenericDomain {
	private String numero;
	private String Bandeira;
	private String nomeCartao;
	private String codigoCartao;
	private LocalDateTime validade;
	
	public Cartao(String numero, String bandeira, String nomeCartao, String codigoCartao, LocalDateTime validade) {
		this.numero = numero;
		Bandeira = bandeira;
		this.nomeCartao = nomeCartao;
		this.codigoCartao = codigoCartao;
		this.validade = validade;
	}

	public String getNumero() {
		return numero;
	}


	public String getBandeira() {
		return Bandeira;
	}


	public String getNomeCartao() {
		return nomeCartao;
	}


	public LocalDateTime getValidade() {
		return validade;
	}
	
}
