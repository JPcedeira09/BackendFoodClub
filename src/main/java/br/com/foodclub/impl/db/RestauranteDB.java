package br.com.foodclub.impl.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.foodclub.abstracts.dao.RestauranteDAO;
import br.com.foodclub.models.Prato;
import br.com.foodclub.models.Restaurante;
import br.com.foodclub.utils.ConnectionFactory;


@Repository
public class RestauranteDB implements RestauranteDAO {
	
	private Connection connection;

	public RestauranteDB() {
		this.connection = ConnectionFactory.getConnection();
	}

	@Override
	public String CadastrarRestaurante(Restaurante restaurante) {

		String query = "INSERT INTO mydb.restaurantes (cnpj, nome, classificacao, senha, telefone, email, entrega) VALUES ( ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setString(1, restaurante.getCnpj());
			statement.setString(2, restaurante.getNome());
			statement.setString(3, restaurante.getClassificacao());
			statement.setString(4, restaurante.getSenha());
			statement.setString(5, restaurante.getTelefone());
			statement.setString(6, restaurante.getEmail());
			statement.setLong(7, restaurante.getEntrega());

			statement.execute();

			System.out.println("<<<iNFO: Cadastro com cnpj:"+restaurante.getCnpj()+", efetuado.>>>");
			return "Cadastro efetuado com sucesso! Bem vindo!!!";

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("<<<iNFO: Cadastro com cnpj:"+restaurante.getCnpj()+", não pode ser efetuado.>>>");
			return "Falha ao efetuar o cadastro! Tente mais tarde.";
		}
	}

	@Override
	public Restaurante AtualizarRestaurante(Restaurante restaurante) {
		String query = "UPDATE mydb.restaurantes SET nome= ? , classificacao= ? , senha= ? , telefone= ? , email= ? , entrega= ?  WHERE cnpj= ? ";

		try {
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setString(1, restaurante.getNome());
			statement.setString(2, restaurante.getClassificacao());
			statement.setString(3, restaurante.getSenha());
			statement.setString(4, restaurante.getTelefone());
			statement.setString(5, restaurante.getEmail());
			statement.setLong(6, restaurante.getEntrega());
			statement.setString(7, restaurante.getCnpj());

			statement.executeUpdate();

			System.out.println("<<<iNFO: Cadastro com cnpj:"+restaurante.getCnpj()+", atualizou o cadastro.>>>");
			return restaurante;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("<<<iNFO: Cadastro com cnpj:"+restaurante.getCnpj()+", efetuado.>>>");
			return null;
		}
	}

	@Override
	public Restaurante BuscarRestaurante(String cnpj) {

		String query = "SELECT * FROM mydb.restaurantes where cnpj = ?";
		Restaurante restaurante = new Restaurante();

		try {
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setString(1, cnpj);

			ResultSet set = statement.executeQuery();
			while(set.next()) {
				restaurante.setCnpj(set.getString("cnpj"));
				restaurante.setNome(set.getString("nome"));
				restaurante.setClassificacao(set.getString("classificacao"));
				restaurante.setSenha(set.getString("senha"));
				restaurante.setTelefone(set.getString("telefone"));
				restaurante.setEmail(set.getString("email"));
				restaurante.setEntrega(set.getInt("entrega"));
			}
			return restaurante;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String DeletarRestaurante(String cnpj) {
		String query = "DELETE FROM mydb.restaurantes WHERE cnpj= ?";

		try {
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setString(1, cnpj);
			statement.execute();

			System.out.println("<<<iNFO: Cadastro com cnpj:"+cnpj+", deletou o cadastro.>>>");
			return "Cadastro deletado com sucesso! Adeus!!!";
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("<<<iNFO: Cadastro com cnpj:"+cnpj+", não conseguiu deletar o cadastro.>>>");
			return "Falha ao deletar o cadastro! Tente mais tarde.";
		}	
	}

	@Override
	public List<Restaurante> BuscarRestaurantes() {
		String query = "SELECT * FROM mydb.restaurantes";
		List<Restaurante> restaurantes = new ArrayList<Restaurante>();
		try {
			PreparedStatement statement = this.connection.prepareStatement(query);

			ResultSet set = statement.executeQuery();
			while(set.next()) {
				Restaurante restaurante = new Restaurante();

				restaurante.setCnpj(set.getString("cnpj"));
				restaurante.setNome(set.getString("nome"));
				restaurante.setClassificacao(set.getString("classificacao"));
				restaurante.setSenha(set.getString("senha"));
				restaurante.setTelefone(set.getString("telefone"));
				restaurante.setEmail(set.getString("email"));
				restaurante.setEntrega(set.getInt("entrega"));
				restaurantes.add(restaurante);
			}
			return restaurantes;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	
	}

	@Override
	public List<Prato> ListarCardapio(String cnpj) {
		String query = "SELECT * FROM mydb.Prato where cnpj = ?";
		List<Prato> pratos = new ArrayList<Prato>();
		try {
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setString(1, cnpj);
			ResultSet set = statement.executeQuery();
			while(set.next()) {
				Prato prato = new Prato();
				prato.setId_cardapio(set.getInt("id_cardapio"));
				prato.setNome(set.getString("nome"));
				prato.setClassificacao(set.getString("classificacao"));
				prato.setPreco(set.getDouble("preco"));
				prato.setTamanho(set.getString("tamanho"));
				prato.setCnpj(set.getString("cnpj"));
				pratos.add(prato);
			}
			return pratos;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	
	}
}
