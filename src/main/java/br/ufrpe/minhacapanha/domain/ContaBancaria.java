package br.ufrpe.minhacapanha.domain;

public class ContaBancaria extends GenericDomain {
	private String numero_conta;
	private String agencia;
	
	public ContaBancaria(String numero_conta, String agencia) {
		this.numero_conta = numero_conta;
		this.agencia = agencia;
	}

	public String getNumero_conta() {
		return numero_conta;
	}

	public String getAgencia() {
		return agencia;
	}
}
