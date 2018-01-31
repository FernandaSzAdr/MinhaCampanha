package br.ufrpe.minhacampanha.domain;

import java.time.LocalDate;
import java.util.ArrayList;
/**
 * 
 * @author raiss
 *
 */
public class ProjetoSocial extends GenericDomain {
	private String tipo, nome, descricao, objetivo;
	private LocalDate data_inicio, data_fim;
	private int qtd_volunt_atual;
	private int qtd_volunt_nec;
	private int id_inst; //REFERENCIA instituição
	
	public ProjetoSocial() {
		
	}
	
	public ProjetoSocial(String tipo, String nome, String descricao, String objetivo, LocalDate data_inicio,
			LocalDate data_fim) {
		this.tipo = tipo;
		this.nome = nome;
		this.descricao = descricao;
		this.objetivo = objetivo;
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;
	}

	public ProjetoSocial(String tipo, String nome, String descricao, String objetivo, LocalDate data_inicio) {
		this.tipo = tipo;
		this.nome = nome;
		this.descricao = descricao;
		this.objetivo = objetivo;
		this.data_inicio = data_inicio;
	}

	public String getTipo() {
		return tipo;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public LocalDate getData_inicio() {
		return data_inicio;
	}

	public LocalDate getData_fim() {
		return data_fim;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public void setData_fim(LocalDate data_fim) {
		this.data_fim = data_fim;
	}

	public int getQtd_volunt_atual() {
		return qtd_volunt_atual;
	}

	public void setQtd_volunt_atual(int qtd_volunt_atual) {
		this.qtd_volunt_atual = qtd_volunt_atual;
	}

	public int getQtd_volunt_nec() {
		return qtd_volunt_nec;
	}

	public void setQtd_volunt_nec(int qtd_volunt_nec) {
		this.qtd_volunt_nec = qtd_volunt_nec;
	}

	public int getId_inst() {
		return id_inst;
	}

	public void setId_inst(int id_inst) {
		this.id_inst = id_inst;
	}

	public void setData_inicio(LocalDate data_inicio) {
		this.data_inicio = data_inicio;
	}
	
}
