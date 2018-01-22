package br.ufrpe.minhacampanha.domain;

import java.io.Serializable;

public class GenericDomain implements Serializable {
	
	private long codigo;

	public long getCodigo() {
		return codigo;  
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}	
}
