package br.com.foodclub.controller;


import java.net.URI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import br.com.foodclub.abstracts.service.ClienteService;
import br.com.foodclub.abstracts.service.EnderecoService;
import br.com.foodclub.abstracts.service.RestauranteService;
import br.com.foodclub.models.Cliente;
import br.com.foodclub.models.EnderecoCliente;
import br.com.foodclub.models.EnderecoRest;
import br.com.foodclub.models.GenericResponse;
import br.com.foodclub.models.Prato;
import br.com.foodclub.models.Restaurante;
import br.com.foodclub.utils.ConnectionFactory;

@RestController
@RequestMapping(path = "/rest",
produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ClienteRestController {

	@GetMapping("/test")
	@ResponseBody
	public Cliente sayPlainTextHello() {  
		System.out.println("Hello world");
		Cliente cliente = new Cliente("461.878.888", "joao", "123456", "123456", "123456", "jp@zup.com.br");
		return cliente;
	}  

	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private ClienteService clienteService;

	@PostMapping("/login")
	@ResponseStatus(HttpStatus.OK)
	public GenericResponse login (@RequestBody Cliente cliente) {
		System.out.println("Fazendo login do CPF:"+cliente.getcpf()+" ...");
		return clienteService.login(cliente.getcpf(),cliente.getSenha());
	}

	@GetMapping("/listarclientes")
	@ResponseStatus(HttpStatus.OK)
	public List<Cliente> listarClientes(){
		System.out.println("Listando os clientes...");
		return clienteService.listar();
	}

	//@JsonFormat(pattern = "dd/MM/yyyy")
	@PostMapping("/cadastrocliente")
	@ResponseStatus(HttpStatus.CREATED)
	public GenericResponse cadastroCliente(@RequestBody Cliente cliente) {

		System.out.println("Cadastrando o cliente do CPF:"+cliente.getcpf()+" ...");
		clienteService.cadastrar(cliente);
		System.out.println("Cadastrando o endereço do CPF:"+cliente.getcpf()+" ...");

		enderecoService.cadastrarCliente(cliente.getEndereco());
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("{cpf}")
				.buildAndExpand(cliente.getcpf()).toUri();

		return new GenericResponse(location.toString(), 201);
	}

	@PostMapping("/getcliente")
	@ResponseStatus(HttpStatus.OK)
	public Cliente getCliente (@RequestBody Cliente cliente) {
		System.out.println("Listando o cliente do CPF:"+cliente.getcpf()+" ...");
		return clienteService.buscar(cliente.getcpf());
	}

	@DeleteMapping("/deletecliente")
	@ResponseStatus(HttpStatus.OK)
	public String deleteCliente (@RequestBody Cliente cliente) throws MySQLIntegrityConstraintViolationException {
		System.out.println("Deletando o cliente do CPF:"+cliente.getcpf()+" ...");
		enderecoService.deletarCliente(cliente.getEndereco().getId_enderecos());
		clienteService.apagar(cliente.getcpf());
		return "";
	}

	@PutMapping("/atualizacliente")
	public Cliente atualizaCliente(@RequestBody Cliente cliente) {
		System.out.println("atualizando o cliente do CPF:"+cliente.getcpf()+" ...");
		return clienteService.ataulizar(cliente);
	}

/*
	@PostMapping("/cadastraendcliente")
	@ResponseStatus(HttpStatus.CREATED)
	public String cadastrarEnderecoCliente(@RequestBody EnderecoCliente endereco) {

		System.out.println("Cadastrando o endereco." + endereco.toString());
		return enderecoService.cadastrarCliente(endereco);
	}*/

	@PutMapping("/atualizarendcliente")
	public EnderecoCliente atualizarEnderecoCliente(@RequestBody EnderecoCliente endereco) {

		System.out.println("Atualizando o endereco do ID:"+endereco.getId_enderecos()+" ...");
		return enderecoService.atualizarCliente(endereco);
	}

	@PostMapping("/getendcliente")
	@ResponseStatus(HttpStatus.OK)
	public EnderecoCliente buscarEnderecoCliente(@RequestBody EnderecoCliente endCliente) {

		System.out.println("Listando o endereco do ID:"+endCliente.getId_enderecos()+" ...");
		return enderecoService.buscarCliente(endCliente.getId_enderecos());
	}

	@DeleteMapping("/deleteendcliente")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Void> deleteEnderecoCliente(@RequestBody EnderecoCliente endCliente) {

		System.out.println("Deletando o endereco do ID:"+endCliente.getId_enderecos()+" ... ");
		enderecoService.deletarCliente(endCliente.getId_enderecos());
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/cadastrarest")
	@ResponseStatus(HttpStatus.CREATED)
	public String cadastrarRestaurante(@RequestBody Restaurante restaurante) {
		return restauranteService.cadastrar(restaurante);
	}

	@PatchMapping("/atualizarrest")
	public Restaurante atualizarRestaurante(@RequestBody Restaurante restaurante) {
		return restauranteService.atualizar(restaurante);
	}

	@GetMapping("/getrest/{cnpj}")
	public Restaurante buscarRestaurante(@PathVariable("cnpj") String cnpj) {
		return restauranteService.buscar(cnpj);
	}

	@DeleteMapping("/deleterest/{cnpj}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public String deletarRestaurante(@PathVariable("cnpj") String cnpj) {
		return restauranteService.deletar(cnpj);
	}

	@GetMapping("/listarrest")
	@ResponseStatus(HttpStatus.OK)
	public List<Restaurante> buscarListaRestaurante() {
		return restauranteService.buscarLista();
	}

	@PostMapping("/cadastraendrest")
	@ResponseStatus(HttpStatus.CREATED)
	public String cadastrarEnderecoRest(@RequestBody EnderecoRest endereco) {

		System.out.println("Cadastrando o endereco." + endereco.toString());
		return enderecoService.cadastrarRest(endereco);
	}

	@PatchMapping("/atualizarendrest")
	public EnderecoRest atualizarEnderecoRest(@RequestBody EnderecoRest endereco) {

		System.out.println("Atualizando o endereco.");
		return enderecoService.atualizarRest(endereco);
	}

	@GetMapping("/getendrest/{id_endereco}")
	@ResponseStatus(HttpStatus.OK)
	public EnderecoRest buscarEnderecoRest(@PathVariable("id_endereco") Integer id_endereco) {

		System.out.println("Listando o endereco.");
		return enderecoService.buscarRest(id_endereco);
	}

	@DeleteMapping("/deleteendrest/{id_endereco}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteEnderecoRest(@PathVariable("id_endereco") Integer id_endereco) {

		System.out.println("Deletando o endereco.");
		enderecoService.deletarCliente(id_endereco);
		return ResponseEntity.noContent().build();
	}

	@Autowired
	private static RestauranteService restauranteService;
	/*
	public static void main(String[] args) {

		testeJPA();
		}


	private static Restaurante testeJPA() {
		EntityManager em = ConnectionFactoryJPA.getEntityManager();

			Restaurante obj = em.find(Restaurante.class, "461.878.999-78");
			return obj;

	}*/

	

	@GetMapping("/listarcard/{cnpj}")
	@ResponseStatus(HttpStatus.OK)
	public List<Prato> ListarCardapio(@PathVariable("cnpj") String cnpj) {
		return restauranteService.ListarCardapio(cnpj);
	}


	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------------------------------------------
	//-----------------------------------------------------------


	private Connection connection;

	public ClienteRestController() {
		this.connection = ConnectionFactory.getConnection();
	}

	@PostMapping("/testDB")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	private Cliente testDB(@RequestBody Cliente cliente) {
		String query = "SELECT *  FROM mydb.clientes WHERE cpf = ?";

		try {
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setString(1,cliente.getcpf());
			ResultSet set = statement.executeQuery();

			while (set.next()){

				cliente.setNome(set.getString("nome"));
				cliente.setTelefone(set.getString("telefone"));
				cliente.setCel(set.getString("cel"));
				cliente.setEmail(set.getString("email"));
				cliente.setcpf(set.getString("cpf"));
			}

			return cliente;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("<<<iNFO: Cadastro com cpf:"+cliente.getcpf()+", não conseguiu fazer um get no cadastro.>>>");
			return null;
		}
	}
}
