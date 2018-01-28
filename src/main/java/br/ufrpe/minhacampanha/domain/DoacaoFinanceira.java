package br.ufrpe.minhacampanha.domain;

import java.util.Date;

public class DoacaoFinanceira extends Doacao{
	
    int ja_em_estoque;
    Date data_ulti_entrada;
    String status_donativo;
    
    public DoacaoFinanceira() {
		// TODO Auto-generated constructor stub
	}

	public int getJa_em_estoque() {
		return ja_em_estoque;
	}

	public void setJa_em_estoque(int ja_em_estoque) {
		this.ja_em_estoque = ja_em_estoque;
	}

	public Date getData_ulti_entrada() {
		return data_ulti_entrada;
	}

	public void setData_ulti_entrada(Date data_ulti_entrada) {
		this.data_ulti_entrada = data_ulti_entrada;
	}

	public String getStatus_donativo() {
		return status_donativo;
	}

	public void setStatus_donativo(String status_donativo) {
		this.status_donativo = status_donativo;
	}
    
    

}
