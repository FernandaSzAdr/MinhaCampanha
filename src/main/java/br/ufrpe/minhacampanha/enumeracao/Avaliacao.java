package br.ufrpe.minhacampanha.enumeracao;

public enum Avaliacao {
	INSATISFATORIO(1), POUCOINSATISFATORIO(2), MEDIO(3), POUCOSATISFATORIO(4), SATISFATORIO(5);
	
	private final int valor;
	
	Avaliacao(int valorOpcao){
		valor = valorOpcao;
	}
	
	public int getValor(){
		return valor;
	}
}
