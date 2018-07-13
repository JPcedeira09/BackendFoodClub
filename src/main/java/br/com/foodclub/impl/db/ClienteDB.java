package br.com.foodclub.impl.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.foodclub.abstracts.dao.ClienteDAO;
import br.com.foodclub.models.Cliente;
import br.com.foodclub.models.GenericResponse;
import br.com.foodclub.utils.ConnectionFactory;


@Repository
public class ClienteDB implements ClienteDAO {

	private Connection connection;

	public ClienteDB() {
		this.connection = ConnectionFactory.getConnection();
	}

	public String cadastrarCliente(Cliente cliente) {

		String query = "INSERT INTO mydb.clientes ( nome, senha, telefone, cel, email, cpf ) VALUES (?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement statement = this.connection.prepareStatement(query);

			statement.setString(1, cliente.getNome());
			statement.setString(2, cliente.getSenha());
			statement.setString(3, cliente.getTelefone());
			statement.setString(4, cliente.getCel());
			statement.setString(5, cliente.getEmail());
			statement.setString(6, cliente.getcpf());

			statement.execute();

			System.out.println("<<<iNFO: Cadastro com CPF:"+cliente.getcpf()+", efetuado.>>>");

			return "Cadastro efetuado com sucesso! Bem vindo!!!";

		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("<<<iNFO: Cadastro com cpf:"+cliente.getcpf()+", não foi efetuado.>>>");
			return "Falha ao efetuar o cadastro! Tente mais tarde.";
		}
	}

	public String apagarCadastroCliente(String cpf) {

		String query = "DELETE FROM mydb.clientes WHERE cpf = ?";

		try {
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setString(1,cpf);
			statement.execute();

			System.out.println("<<<iNFO: Cadastro com cpf:"+cpf+", deletou o cadastro.>>>");
			return "Cadastro deletado com sucesso! Adeus!!!";
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("<<<iNFO: Cadastro com cpf:"+cpf+", não conseguiu deletar o cadastro.>>>");
			return "Falha ao deletar o cadastro! Tente mais tarde.";
		}
	}

	public Cliente atualizarCadastroCliente(Cliente cliente) {
		String query = "UPDATE mydb.clientes SET nome = ?, senha = ?, telefone = ?, cel = ?, email = ? WHERE cpf =  ? ";

		try {
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setString(1,cliente.getNome());
			statement.setString(2,cliente.getSenha());
			statement.setString(3,cliente.getTelefone());
			statement.setString(4,cliente.getCel());
			statement.setString(5,cliente.getEmail());
			statement.setString(6,cliente.getcpf());

			statement.executeUpdate();

			System.out.println("<<<iNFO: Cadastro com cpf:"+cliente.getcpf()+", atualizou o cadastro.>>>");
			return cliente;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("<<<iNFO: Cadastro com cpf:"+cliente.getcpf()+", não conseguiu atualizar o cadastro.>>>");
			return null;
		}
	}

	public Cliente buscarCliente(String cpf) {

		String query = "SELECT *  FROM mydb.clientes WHERE cpf = ?";
		Cliente cliente = new Cliente();

		try {
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setString(1,cpf);
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
			System.out.println("<<<iNFO: Cadastro com cpf:"+cpf+", não conseguiu fazer um get no cadastro.>>>");
			return null;
		}
	}

	public List<Cliente> buscarClientes() {
		String query = "SELECT * FROM mydb.clientes ";
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			PreparedStatement statement = this.connection.prepareStatement(query);
			ResultSet set = statement.executeQuery();
			while (set.next()){
				Cliente cliente = new Cliente();
				cliente.setNome(set.getString("nome"));
				cliente.setTelefone(set.getString("telefone"));
				cliente.setCel(set.getString("cel"));
				cliente.setEmail(set.getString("email"));
				cliente.setcpf(set.getString("cpf"));
				clientes.add(cliente);
			}

			return clientes;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}    }

	@Override
	public GenericResponse login(String cpf, String senha) {
		
		String query = "SELECT *  FROM mydb.clientes WHERE cpf = ? and senha = ?";
		Cliente cliente = new Cliente("", "", "", "", "", "");
		GenericResponse response = new GenericResponse("", 0);

		try {
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setString(1,cpf);
			statement.setString(2,senha);

			ResultSet set = statement.executeQuery();
			while (set.next()){

				cliente.setNome(set.getString("nome"));
				cliente.setTelefone(set.getString("telefone"));
				cliente.setCel(set.getString("cel"));
				cliente.setEmail(set.getString("email"));
				cliente.setcpf(set.getString("cpf"));
				
			}
			if(cliente.getcpf() != "" || cliente.getSenha() != "") {
				response.setMsg("valid");
				response.setStatus(200);
				return response;
			}else {
				response.setMsg("not valid");
				response.setStatus(0);
				return response;	
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("<<<iNFO: Cadastro com cpf:"+cpf+", não conseguiu fazer um get no cadastro.>>>");
			return null;
		}
	}


}
