package br.ufrpe.minhacampanha.enumeracao;

public enum SituacaoItem {
	ACEITO(1), REPAROS_NECESSARIOS(2), REJEITADO(3), EM_ANALISE(4);
	
	private final int valor;
	
	SituacaoItem(int valorOpcao){
		valor = valorOpcao;
	}
	
	public int getValor(){
		return valor;
	}
}
