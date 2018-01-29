package br.ufrpe.minhacampanha.domain;

import java.util.Date;
/**
 * 
 * @author Srta Camelo
 *
 */
public class Donativo_produto extends Doacao{
	
	private int qtd_donativo_doado;
	private String status_donativo;
	public int getQtd_donativo_doado() {
		return qtd_donativo_doado;
	}
	public void setQtd_donativo_doado(int qtd_donativo_doado) {
		this.qtd_donativo_doado = qtd_donativo_doado;
	}
	public String getStatus_donativo() {
		return status_donativo;
	}
	public void setStatus_donativo(String status_donativo) {
		this.status_donativo = status_donativo;
	}
    
    
 
    

}
