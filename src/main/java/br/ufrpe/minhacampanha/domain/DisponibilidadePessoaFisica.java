package br.ufrpe.minhacampanha.domain;

import java.sql.Time;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class DisponibilidadePessoaFisica extends GenericDomain{
	private LocalDate dia;
	private String dia_aux;
	private Time hora_inicio, hora_fim;
	private int cod_pf_voluntaria;
	private int confirmacao_dia, dia_de_semana, ind_feriado;
	private String periodo_dia;
	
	public LocalDate getDia() {
		return dia;
	}
	public void setDia(LocalDate dia) {
		this.dia = dia;
	}
	public Time getHora_inicio() {
		return hora_inicio;
	}
	public void setHora_inicio(Time hora_inicio) {
		this.hora_inicio = hora_inicio;
	}
	public Time getHora_fim() {
		return hora_fim;
	}
	public void setHora_fim(Time hora_fim) {
		this.hora_fim = hora_fim;
	}
	public int getCod_pf_voluntaria() {
		return cod_pf_voluntaria;
	}
	public void setCod_pf_voluntaria(int cod_pf_voluntaria) {
		this.cod_pf_voluntaria = cod_pf_voluntaria;
	}
	public int getConfirmacao_dia() {
		return confirmacao_dia;
	}
	public void setConfirmacao_dia(int confirmacao_dia) {
		this.confirmacao_dia = confirmacao_dia;
	}
	public int getDia_de_semana() {
		return dia_de_semana;
	}
	public void setDia_de_semana(int dia_de_semana) {
		this.dia_de_semana = dia_de_semana;
	}
	public int getInd_feriado() {
		return ind_feriado;
	}
	public void setInd_feriado(int ind_feriado) {
		this.ind_feriado = ind_feriado;
	}
	public String getPeriodo_dia() {
		return periodo_dia;
	}
	public void setPeriodo_dia(String periodo_dia) {
		this.periodo_dia = periodo_dia;
	}
	public String getDia_aux() {
		return dia_aux;
	}
	public void setDia_aux(String dia_aux) {
		this.dia_aux = dia_aux;
	}
}
