package br.teste.estacionamento.veiculo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.teste.estacionamento.cliente.Cliente;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, String>{
	
	Veiculo findByPlacaAndCliente(String placa, Cliente cliente);
	
	Veiculo findByCliente(Cliente cliente);
}
