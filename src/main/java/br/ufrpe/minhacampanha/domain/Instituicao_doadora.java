package br.ufrpe.minhacampanha.domain;

import java.time.LocalDate;
/**
 * 
 * @author raiss
 *
 */
@SuppressWarnings("serial")
public class Instituicao_doadora extends Instituicao{
	private LocalDate dt_ultima_doacao;
    private int num_doacoes_prod;		
    private int num_doacoes_fin;
    
    public Instituicao_doadora(){
 
    }
    
	public LocalDate getDt_ultima_doacao() {
		return dt_ultima_doacao;
	}
	public void setDt_ultima_doacao(LocalDate dt_ultima_doacao) {
		this.dt_ultima_doacao = dt_ultima_doacao;
	}
	public int getNum_doacoes_prod() {
		return num_doacoes_prod;
	}
	public void setNum_doacoes_prod(int num_doacoes_prod) {
		this.num_doacoes_prod = num_doacoes_prod;
	}
	public int getNum_doacoes_fin() {
		return num_doacoes_fin;
	}
	public void setNum_doacoes_fin(int num_doacoes_fin) {
		this.num_doacoes_fin = num_doacoes_fin;
	}
    
    
}
