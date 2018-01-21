package br.ufrpe.minhacampanha.domain;

import java.time.LocalDate;

public class PedidoProduto extends GenericDomain{
	private Long campanha;
	private LocalDate data_pedido;
	private LocalDate data_atendimento;
	private short status_pedido_enum;
	private Long instituicao;
	
	public PedidoProduto(Long campanha, LocalDate data_pedido, LocalDate data_atendimento, short status_pedido_enum,
			Long instituicao) {
		this.campanha = campanha;
		this.data_pedido = data_pedido;
		this.data_atendimento = data_atendimento;
		this.status_pedido_enum = status_pedido_enum;
		this.instituicao = instituicao;
	}

	public PedidoProduto(Long campanha, LocalDate data_pedido, Long instituicao) {
		this.campanha = campanha;
		this.data_pedido = data_pedido;
		this.instituicao = instituicao;
	}

	public LocalDate getData_atendimento() {
		return data_atendimento;
	}

	public void setData_atendimento(LocalDate data_atendimento) {
		this.data_atendimento = data_atendimento;
	}

	public short getStatus_pedido_enum() {
		return status_pedido_enum;
	}

	public void setStatus_pedido_enum(short status_pedido_enum) {
		this.status_pedido_enum = status_pedido_enum;
	}

	public Long getCampanha() {
		return campanha;
	}

	public LocalDate getData_pedido() {
		return data_pedido;
	}

	public Long getInstituicao() {
		return instituicao;
	}

}
