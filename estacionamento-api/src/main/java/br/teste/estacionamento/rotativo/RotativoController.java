package br.teste.estacionamento.rotativo;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.teste.estacionamento.cliente.Cliente;
import br.teste.estacionamento.cliente.ClienteRepository;
import br.teste.estacionamento.veiculo.Veiculo;
import br.teste.estacionamento.veiculo.VeiculoRepository;

@RestController
@RequestMapping("/rotativos")
public class RotativoController {

	private RotativoRepository rotativoRepository;

	private VeiculoRepository veiculoRepository;

	private ClienteRepository clienteRepository;

	RotativoController(RotativoRepository rotativoRepository, VeiculoRepository veiculoRepository,
			ClienteRepository clienteRepository) {
		this.rotativoRepository = rotativoRepository;
		this.veiculoRepository = veiculoRepository;
		this.clienteRepository = clienteRepository;
	}

	@GetMapping
	public List<Rotativo> findAll() {
		return this.rotativoRepository.findAll();
	}
	
	@GetMapping("/{filter}")
	public List<Rotativo> findAllFilter(@PathVariable Integer filter) {
		System.out.println("Enviando veículos estacionados...");
		return this.rotativoRepository.findAllEstacionados();
	}
	
	

	@GetMapping(path = { "/{placa}/{idCliente}" })
	public ResponseEntity<Rotativo> findById(@PathVariable String placa, @PathVariable long idCliente) {
		Cliente c = clienteRepository.getById(idCliente);
		if (c == null) {
			return ResponseEntity.notFound().build();
		}

		Veiculo v = veiculoRepository.findByPlacaAndCliente(placa, c);

		if (v == null) {
			return ResponseEntity.notFound().build();
		}

		RotativoId rId = new RotativoId(v.getPlaca(), c.getId());
		return rotativoRepository.findById(rId).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{placa}/{idCliente}" })
	public ResponseEntity<?> delete(@PathVariable String placa, @PathVariable Long idCliente) {
		System.out.println(placa);
		System.out.println(idCliente);
		Cliente c = clienteRepository.getById(idCliente);
		if (c == null) {
			return ResponseEntity.notFound().build();
		}

		Veiculo v = veiculoRepository.findByPlacaAndCliente(placa, c);

		if (v == null) {
			return ResponseEntity.notFound().build();
		}

		RotativoId rId = new RotativoId(v.getPlaca(), c.getId());
		return rotativoRepository.findById(rId).map(record -> {
			rotativoRepository.deleteById(rId);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Rotativo create(@RequestBody Rotativo rotativo) {
		System.out.println(rotativo.getRotativoId().getPlaca());
		return rotativoRepository.save(rotativo);
	}

	@PutMapping(value = "/{placa}/{idCliente}")
	public ResponseEntity<Rotativo> update(@PathVariable("placa") String placaVeiculo,
			@PathVariable("idCliente") long idCliente, @RequestBody Rotativo rotativo) {

		Cliente c = clienteRepository.getById(idCliente);
		if (c == null) {
			return ResponseEntity.notFound().build();
		}

		Veiculo v = veiculoRepository.findByPlacaAndCliente(placaVeiculo, c);

		if (v == null) {
			return ResponseEntity.notFound().build();
		}

		RotativoId rId = new RotativoId(v.getPlaca(), c.getId());
		return rotativoRepository.findById(rId).map(retorno -> {
			retorno.setRotativoId(rotativo.getRotativoId());
			retorno.setMomentoEntrada(rotativo.getMomentoEntrada());
			retorno.setMomentoSaida(rotativo.getMomentoSaida());
			Rotativo updated = rotativoRepository.save(retorno);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}
}
