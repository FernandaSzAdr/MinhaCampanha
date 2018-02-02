package br.ufrpe.minhacampanha.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("serial")
public class PessoaFisicaVoluntario extends PessoaFisica{
	private int id_ps;
	private LocalDate data_inicio;
	private LocalDate data_fim;
	private Carro carro;
	private boolean tem_veiculo;
	
	public PessoaFisicaVoluntario(){
	}
	
	public int getId_ps() {
		return id_ps;
	}


	public void setId_ps(int id_ps) {
		this.id_ps = id_ps;
	}


	public LocalDate getData_inicio() {
		return data_inicio;
	}
	public void setData_inicio(LocalDate data_inicio) {
		this.data_inicio = data_inicio;
	}
	public LocalDate getData_fim() {
		return data_fim;
	}
	public void setData_fim(LocalDate data_fim) {
		this.data_fim = data_fim;
	}
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}



	public boolean getTem_veiculo() {
		return tem_veiculo;
	}



	public void setTem_veiculo(boolean tem_veiculo) {
		this.tem_veiculo = tem_veiculo;
	}
	
	
}
