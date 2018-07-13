package br.ufrpe.minhacampanha.domain;

@SuppressWarnings("serial")
public class PessoaFisicaVoluntario extends PessoaFisica{
	private String data_inicio;
	private String data_fim;
	private Carro carro;
	private boolean tem_veiculo;
	private String id_S;
	
	public String getId_S() {
		return id_S;
	}
	public void setId_S(String id_S) {
		this.id_S = id_S;
	}
	public String getData_inicio() {
		return data_inicio;
	}
	public void setData_inicio(String data_inicio) {
		this.data_inicio = data_inicio;
	}
	public String getData_fim() {
		return data_fim;
	}
	public void setData_fim(String data_fim) {
		this.data_fim = data_fim;
	}
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	public boolean isTem_veiculo() {
		return tem_veiculo;
	}
	public void setTem_veiculo(boolean tem_veiculo) {
		this.tem_veiculo = tem_veiculo;
	}	
}
