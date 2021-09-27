//package br.teste.estacionamento;
//
//import java.sql.Timestamp;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import br.teste.estacionamento.cliente.Cliente;
//import br.teste.estacionamento.cliente.ClienteRepository;
//import br.teste.estacionamento.rotativo.Rotativo;
//import br.teste.estacionamento.rotativo.RotativoId;
//import br.teste.estacionamento.rotativo.RotativoRepository;
//import br.teste.estacionamento.veiculo.Veiculo;
//import br.teste.estacionamento.veiculo.VeiculoRepository;
//
//@Component
//public class DataLoader implements CommandLineRunner {
//
//	private final Logger logger = LoggerFactory.getLogger(DataLoader.class);
//
//	@Autowired
//	private ClienteRepository clienteRepository;
//
//	@Autowired
//	private VeiculoRepository veiculoRepository;
//	
//	@Autowired
//	private RotativoRepository rotativoRepository;
//	
//	
//	@Override
//	public void run(String... args) throws Exception {
//
//		logger.info("Carregando dados de teste na inicialização...");
//
//		this.dadosClientes();
//		this.dadosVeiculos();
//		this.dadosRotativos();
//		
//
//		logger.info("Clientes carregados: {}", clienteRepository.count());
//		logger.info("Veículos carregados: {}", veiculoRepository.count());
//		logger.info("Rotativos carregados: {}", rotativoRepository.count());
//
//		logger.info("Finalizando teste na inicialização...");
//	}
//	
//	private void dadosClientes() {
//		Cliente c1 = new Cliente("Zé", "32312312");
//		Cliente c2 = new Cliente("Biu", "42342");
//		Cliente c3 = new Cliente("Elk", "23143243");
//		
//		clienteRepository.save(c1);
//		clienteRepository.save(c2);
//		clienteRepository.save(c3);
//		
//	}
//
//	private void dadosVeiculos() {
//		Cliente c1 = clienteRepository.getById(1L);
//		Cliente c2 = clienteRepository.getById(2L);
//		Cliente c3 = clienteRepository.getById(3L);
//		
//		Veiculo v1 = new Veiculo();
//		v1.setCliente(c1);
//		v1.setCor("Preto");
//		v1.setModelo("Uno");
//		
//		Veiculo v2 = new Veiculo();
//		v2.setCliente(c2);
//		v2.setCor("Classic");
//		v2.setModelo("Prata");
//		
//		Veiculo v3 = new Veiculo();
//		v3.setCliente(c3);
//		v3.setCor("Classic");
//		v3.setModelo("Prata");
//		
//		veiculoRepository.save(v1);
//		veiculoRepository.save(v2);
//		veiculoRepository.save(v3);
//	}
//
//	
//	private void dadosRotativos() {
//		Cliente c1 = clienteRepository.getById(1L);
//		Cliente c2 = clienteRepository.getById(2L);
//		Cliente c3 = clienteRepository.getById(3L);
//		
//		Veiculo v1 = veiculoRepository.findByIdAndCliente(1L, c1);
//		Veiculo v2 = veiculoRepository.findByIdAndCliente(2L, c2);
//		Veiculo v3 = veiculoRepository.findByIdAndCliente(3L, c3);
//		
//		
//		Timestamp t1 = new Timestamp(System.currentTimeMillis());
//		Timestamp t2 = new Timestamp(System.currentTimeMillis());
//		
//		RotativoId rId1 = new RotativoId(v1.getId(), c1.getId());
//		Rotativo r1 = new Rotativo(rId1, t1, t2);
//		
//		Timestamp t3 = new Timestamp(System.currentTimeMillis());
//		Timestamp t4 = new Timestamp(System.currentTimeMillis());
//
//		RotativoId rId2 = new RotativoId(v2.getId(), c2.getId());
//		Rotativo r2 = new Rotativo(rId2, t3, t4);
//		
//		Timestamp t5 = new Timestamp(System.currentTimeMillis());
//		Timestamp t6 = new Timestamp(System.currentTimeMillis());
//		
//		RotativoId rId3 = new RotativoId(v3.getId(), c3.getId());
//		Rotativo r3 = new Rotativo(rId3, t5, t6);
//		
//		rotativoRepository.save(r1);
//		rotativoRepository.save(r2);
//		rotativoRepository.save(r3);
//	}
//}