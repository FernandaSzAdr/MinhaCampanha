package br.ufrpe.minhacampanha.domain;

import java.time.LocalDate;
import java.time.LocalTime;

@SuppressWarnings("serial")
public class DisponibilidadePessoaFisica extends GenericDomain{
	private LocalDate dia;
	private LocalTime hora_inicio, hora_fim;
	private int cod_pf_voluntaria;
	private boolean confirmacao_dia, dia_de_semana, ind_feriado;
	private String periodo_dia;
    



	public LocalTime getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(LocalTime hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public LocalTime getHora_fim() {
		return hora_fim;
	}

	public void setHora_fim(LocalTime hora_fim) {
		this.hora_fim = hora_fim;
	}

	public boolean isConfirmacao_dia() {
		return confirmacao_dia;
	}

	public void setConfirmacao_dia(boolean confirmacao_dia) {
		this.confirmacao_dia = confirmacao_dia;
	}

	public boolean isDia_de_semana() {
		return dia_de_semana;
	}

	public void setDia_de_semana(boolean dia_de_semana) {
		this.dia_de_semana = dia_de_semana;
	}

	public boolean isInd_feriado() {
		return ind_feriado;
	}

	public void setInd_feriado(boolean ind_feriado) {
		this.ind_feriado = ind_feriado;
	}

	public String getPeriodo_dia() {
		return periodo_dia;
	}

	public void setPeriodo_dia(String periodo_dia) {
		this.periodo_dia = periodo_dia;
	}

	public LocalDate getDia() {
		return dia;
	}

	public void setDia(LocalDate dia) {
		this.dia = dia;
	}

	public int getCod_pf_voluntaria() {
		return cod_pf_voluntaria;
	}

	public void setCod_pf_voluntaria(int cod_pf_voluntaria) {
		this.cod_pf_voluntaria = cod_pf_voluntaria;
	}


}
