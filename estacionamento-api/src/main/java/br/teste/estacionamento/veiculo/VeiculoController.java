package br.teste.estacionamento.veiculo;

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

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

	private VeiculoRepository veiculoRepository;

	public VeiculoController(VeiculoRepository veiculoRepository) {
		this.veiculoRepository = veiculoRepository;
	}

	@GetMapping
	public List<Veiculo> findAll() {
		return veiculoRepository.findAll();
	}

	@GetMapping(path = { "/{placa}" })
	public ResponseEntity<Veiculo> findById(@PathVariable String placa) {
		return veiculoRepository.findById(placa).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{placa}" })
	public ResponseEntity<?> delete(@PathVariable String placa) {
		return veiculoRepository.findById(placa).map(record -> {
			record.setCliente(null);
			veiculoRepository.save(record);
			veiculoRepository.deleteById(placa);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Veiculo create(@RequestBody Veiculo veiculo) {
		System.out.println("passei");
		System.out.println(veiculo.getPlaca());
		return veiculoRepository.save(veiculo);
	}

	@PutMapping(value = "/{placa}")
	public ResponseEntity<Veiculo> update(@PathVariable("placa") String placa, @RequestBody Veiculo veiculo) {
		return veiculoRepository.findById(placa).map(retorno -> {
			retorno.setModelo(veiculo.getModelo());
			retorno.setCliente(veiculo.getCliente());
			retorno.setCor(veiculo.getCor());
			Veiculo updated = veiculoRepository.save(retorno);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

}
