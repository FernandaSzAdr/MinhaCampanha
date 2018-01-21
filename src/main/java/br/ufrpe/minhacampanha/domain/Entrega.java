package br.ufrpe.minhacampanha.domain;

import java.time.LocalDate;
import java.time.LocalTime;


/**
 * No banco essa tabela possui mais algumas colunas, são elas:
 * id_receptora_da_entrega, numero_documento, id_voluntario_responsavel,
 * codigo_ponto_de_coleta.
 * 
 * @author Fernanda
 */

public class Entrega extends GenericDomain{
	private LocalDate data_entrega, data_agendada;
	private LocalTime hora_agendada;
	private short status_entrega_enum;
	private String observacao;
	
	public Entrega(LocalDate data_entrega, LocalDate data_agendada, LocalTime hora_agendada, short status,
			String observacao) {
		this.data_entrega = data_entrega;
		this.data_agendada = data_agendada;
		this.hora_agendada = hora_agendada;
		this.status_entrega_enum = status;
		this.observacao = observacao;
	}

	public Entrega(LocalDate data_agendada, LocalTime hora_agendada, short status, String observacao) {
		this.data_agendada = data_agendada;
		this.hora_agendada = hora_agendada;
		this.status_entrega_enum = status;
		this.observacao = observacao;
	}

	public LocalDate getData_entrega() {
		return data_entrega;
	}

	public LocalDate getData_agendada() {
		return data_agendada;
	}

	public LocalTime getHora_agendada() {
		return hora_agendada;
	}

	public short getStatus() {
		return status_entrega_enum;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setData_entrega(LocalDate data_entrega) {
		this.data_entrega = data_entrega;
	}

	public void setData_agendada(LocalDate data_agendada) {
		this.data_agendada = data_agendada;
	}

	public void setHora_agendada(LocalTime hora_agendada) {
		this.hora_agendada = hora_agendada;
	}

	public void setStatus(short status) {
		this.status_entrega_enum = status;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}	
}
