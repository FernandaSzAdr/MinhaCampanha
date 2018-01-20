package br.ufrpe.minhacapanha.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import br.ufrpe.minhacampanha.enumeracao.StatusEntrega;

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
	private StatusEntrega status;
	private String observacao;
	
	public Entrega(LocalDate data_entrega, LocalDate data_agendada, LocalTime hora_agendada, StatusEntrega status,
			String observacao) {
		this.data_entrega = data_entrega;
		this.data_agendada = data_agendada;
		this.hora_agendada = hora_agendada;
		this.status = status;
		this.observacao = observacao;
	}

	public Entrega(LocalDate data_agendada, LocalTime hora_agendada, StatusEntrega status, String observacao) {
		this.data_agendada = data_agendada;
		this.hora_agendada = hora_agendada;
		this.status = status;
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

	public StatusEntrega getStatus() {
		return status;
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

	public void setStatus(StatusEntrega status) {
		this.status = status;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}	
}
