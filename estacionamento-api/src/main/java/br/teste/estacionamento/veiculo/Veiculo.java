package br.teste.estacionamento.veiculo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.teste.estacionamento.cliente.Cliente;

@Entity
public class Veiculo{

	@Id
	private String placa;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cliente_id", referencedColumnName = "id")
	private Cliente cliente;

	private String modelo;

	private String cor;

	public Veiculo() {
	}
		
	public Veiculo(String placa, String modelo, String cor) {
		this.placa = placa;
		this.modelo = modelo;
		this.cor = cor;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getPlaca() {
		return placa;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

}
