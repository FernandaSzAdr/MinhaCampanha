package br.ufrpe.minhacampanha.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class GenericDomain implements Serializable {
	
	private int codigo;

	public int getCodigo() {
		return codigo;  
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}	
}
