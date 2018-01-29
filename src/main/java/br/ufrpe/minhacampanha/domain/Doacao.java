package br.ufrpe.minhacampanha.domain;

import java.time.LocalDate;

/**
 * Essa classe vai ser utilizado nas tabelas donativo_financeiro
 * e donativo_produto.
 * 
 * Pode-se observar que ela contém informações dos dois tipos de doações.
 * 
 * @author Fernanda
 */
public abstract class Doacao extends GenericDomain {
	private LocalDate dataDoacao;
	private int id_inst_doadora		;
    private int id_pessoa_doadora;
    private int id_campanha;

	public LocalDate getDataDoacao() {
		return dataDoacao;
	}

	public int getId_inst_doadora() {
		return id_inst_doadora;
	}

	public void setId_inst_doadora(int id_inst_doadora) {
		this.id_inst_doadora = id_inst_doadora;
	}

	public int getId_pessoa_doadora() {
		return id_pessoa_doadora;
	}

	public void setId_pessoa_doadora(int id_pessoa_doadora) {
		this.id_pessoa_doadora = id_pessoa_doadora;
	}

	public int getId_campanha() {
		return id_campanha;
	}

	public void setId_campanha(int id_campanha) {
		this.id_campanha = id_campanha;
	}

	public void setDataDoacao(LocalDate dataDoacao) {
		this.dataDoacao = dataDoacao;
	}
	
	
	
	
}
