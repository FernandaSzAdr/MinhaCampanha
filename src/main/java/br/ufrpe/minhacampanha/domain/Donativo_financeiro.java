package br.ufrpe.minhacampanha.domain;

import java.util.Date;
/**
 * 
 * @author Srta Camelo
 *
 */
public class Donativo_financeiro extends Doacao{
	
    int ja_em_estoque;
    Date data_ulti_entrada;
    int id_campanha;
    private float qtd_valor_doado;
    
    public Donativo_financeiro() {
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
	
	public float getQtd_valor_doado() {
		return qtd_valor_doado;
	}

	public void setQtd_valor_doado(float qtd_valor_doado) {
		this.qtd_valor_doado = qtd_valor_doado;
	}	

    

}
