package br.ufrpe.minhacampanha.enumeracao;

public enum StatusEntrega {
	AGUARDANDO_RETIRADA(1), RETIRADO(2), CANCELADO(3), FINALIZADO(4);
	
	private final int valor;
	
	StatusEntrega(int valorOpcao){
		valor = valorOpcao;
	}
	
	public int getValor(){
		return valor;
	}
}
