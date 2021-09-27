package br.teste.estacionamento.rotativo;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class RotativoId implements Serializable {

	private String placa;

	private Long idCliente;

	public RotativoId() {
	}

	public RotativoId(String placa, Long idCliente) {
		this.placa = placa;
		this.idCliente = idCliente;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placaVeiculo) {
		this.placa = placaVeiculo;
	}

}
