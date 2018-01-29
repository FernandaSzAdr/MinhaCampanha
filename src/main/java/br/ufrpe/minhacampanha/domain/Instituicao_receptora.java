package br.ufrpe.minhacampanha.domain;
import java.sql.Date;
public class Instituicao_receptora extends Instituicao{

	private int id_recep;		
	private Date dt_ultima_recep ;	
	private int num_doacoes_recebi ;
	
	public int getId_recep() {
		return id_recep;
	}
	public void setId_recep(int id_recep) {
		this.id_recep = id_recep;
	}
	public Date getDt_ultima_recep() {
		return dt_ultima_recep;
	}
	public void setDt_ultima_recep(Date dt_ultima_recep) {
		this.dt_ultima_recep = dt_ultima_recep;
	}
	public int getNum_doacoes_recebi() {
		return num_doacoes_recebi;
	}
	public void setNum_doacoes_recebi(int num_doacoes_recebi) {
		this.num_doacoes_recebi = num_doacoes_recebi;
	}
	
}
