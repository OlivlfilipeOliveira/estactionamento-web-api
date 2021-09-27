package br.teste.estacionamento.rotativo;

import java.sql.Timestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Rotativo {

	@EmbeddedId
	private RotativoId rotativoId;

	private Timestamp momentoEntrada;

	private Timestamp momentoSaida;

	public Rotativo() {
	}

	public Rotativo(RotativoId rotativoId, Timestamp momentoEntrada, Timestamp momentoSaida) {
		this.rotativoId = rotativoId;
		this.momentoEntrada = momentoEntrada;
		this.momentoSaida = momentoSaida;
	}
	
	public RotativoId getRotativoId() {
		return rotativoId;
	}
	
	public void setRotativoId(RotativoId rotativoId) {
		this.rotativoId = rotativoId;
	}
	
	public Timestamp getMomentoEntrada() {
		return momentoEntrada;
	}

	public void setMomentoEntrada(Timestamp momentoEntrada) {
		this.momentoEntrada = momentoEntrada;
	}

	public Timestamp getMomentoSaida() {
		return momentoSaida;
	}

	public void setMomentoSaida(Timestamp momentoSaida) {
		this.momentoSaida = momentoSaida;
	}

}
