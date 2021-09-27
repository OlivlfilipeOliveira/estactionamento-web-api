package br.teste.estacionamento.cliente;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.teste.estacionamento.veiculo.Veiculo;
import br.teste.estacionamento.veiculo.VeiculoRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	private ClienteRepository clienteRepository;

	private VeiculoRepository veiculoRepository;

	public ClienteController(ClienteRepository clienteRepository, VeiculoRepository veiculoRepository) {
		this.clienteRepository = clienteRepository;
		this.veiculoRepository = veiculoRepository;
	}

	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		return new ResponseEntity<List<Cliente>>(clienteRepository.findAll(), HttpStatus.OK);
		// return clienteRepository.findAll();
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<Cliente> findById(@PathVariable long id) {
		return clienteRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable long id) {
		return clienteRepository.findById(id).map(record -> {
			Veiculo v = veiculoRepository.findByCliente(record);
			if(v!=null) {
				v.setCliente(null);
				veiculoRepository.deleteById(v.getPlaca());
			}
			clienteRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Cliente> create(@RequestBody Cliente pessoa) {
		return new ResponseEntity<Cliente>(clienteRepository.save(pessoa), HttpStatus.ACCEPTED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Cliente> update(@PathVariable("id") long id, @RequestBody Cliente cliente) {
		return clienteRepository.findById(id).map(retorno -> {
			retorno.setNome(cliente.getNome());
			retorno.setTelefone(cliente.getTelefone());
			Cliente updated = clienteRepository.save(retorno);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

}
