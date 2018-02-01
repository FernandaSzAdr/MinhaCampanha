package br.ufrpe.minhacampanha.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("serial")
public class PessoaFisicaVoluntario extends GenericDomain{
	private int pessoa;
	private LocalDate data_inicio;
	private LocalDate data_fim;
	private Carro carro;
	private int tem_veiculo;
	
	public PessoaFisicaVoluntario(){
		data_inicio = LocalDate.now();
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String text = data_inicio.format(formatters);
	    data_inicio = LocalDate.parse(text, formatters);
	}
	
	public int getPessoa() {
		return pessoa;
	}
	public void setPessoa(int pessoa) {
		this.pessoa = pessoa;
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
	public int getTem_veiculo() {
		return tem_veiculo;
	}
	public void setTem_veiculo(int tem_veiculo) {
		this.tem_veiculo = tem_veiculo;
	}
}
