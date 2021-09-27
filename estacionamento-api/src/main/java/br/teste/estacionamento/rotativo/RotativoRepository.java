package br.teste.estacionamento.rotativo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RotativoRepository extends JpaRepository<Rotativo, RotativoId>{
	
	@Query("select r from Rotativo r where CURRENT_TIMESTAMP between r.momentoEntrada and r.momentoSaida")
	List<Rotativo> findAllEstacionados();
}
