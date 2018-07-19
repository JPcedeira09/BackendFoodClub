package br.com.foodclub.impl.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.foodclub.abstracts.dao.CardapioDAO;
import br.com.foodclub.models.Prato;

@Repository
public class CardapioDB implements CardapioDAO {

	Connection connection;
	
	public Prato BuscarPrato(int id_cardapio) {

		String query = "SELECT * FROM mydb.Prato where id_cardapio = ?";
		Prato prato = new Prato();
		try {
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setInt(1, id_cardapio);

			ResultSet set = statement.executeQuery();
			while(set.next()) {
				prato.setId_cardapio(set.getInt("id_cardapio"));
				prato.setNome(set.getString("nome"));
				prato.setClassificacao(set.getString("classificacao"));
				prato.setPreco(set.getDouble("preco"));
				prato.setTamanho(set.getString("tamanho"));
				prato.setDisponivel(set.getInt("disponivel"));
				prato.setNota(set.getDouble("nota"));
				prato.setCnpj(set.getString("cnpj"));

			}
			return prato;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	
	}

	public List<Prato> BuscarPratos(String CNPJ) {
		String query = "SELECT * FROM mydb.Prato where CNPJ = ?";
		List<Prato> pratos = new ArrayList<Prato>();
		try {
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setString(1, CNPJ);

			ResultSet set = statement.executeQuery();
			while(set.next()) {

				Prato prato = new Prato();
				prato.setId_cardapio(set.getInt("id_cardapio"));
				prato.setNome(set.getString("nome"));
				prato.setClassificacao(set.getString("classificacao"));
				prato.setPreco(set.getDouble("preco"));
				prato.setTamanho(set.getString("tamanho"));
				prato.setDisponivel(set.getInt("disponivel"));
				prato.setNota(set.getDouble("nota"));
				prato.setCnpj(set.getString("cnpj"));

				pratos.add(prato);

			}
			return pratos;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	
	}

	@Override
	public String CadastrarPrato(Prato prato) {
		String query = "";

		try {
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setString(1,prato.getNome());
			statement.setString(2,prato.getClassificacao());
			statement.setDouble(3,prato.getPreco());
			statement.setString(4,prato.getTamanho());
			statement.setInt(5, prato.getDisponivel());
			statement.setDouble(6, prato.getNota());
			statement.setString(7, prato.getCnpj());

			statement.execute();

			System.out.println("<<<iNFO: Prato com do restaurante com CNPJ:"+prato.getCnpj()+", cadastrou um novo prato.>>>");
			return "Cadastro do novo prato foi feito com sucesso!";
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("<<<iNFO: Prato com do restaurante com CNPJ:"+prato.getCnpj()+",não pode cadastrar um novo prato.>>>");
			return "Falha ao adicionar novo prato! Tente mais tarde.";
		}	
	}

	@Override
	public String AtualizarPrato(Prato prato) {
		String query = "";

		try {
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setString(1,prato.getNome());
			statement.setString(2,prato.getClassificacao());
			statement.setDouble(3,prato.getPreco());
			statement.setString(4,prato.getTamanho());
			statement.setInt(5, prato.getDisponivel());
			statement.setDouble(6, prato.getNota());
			statement.setString(7, prato.getCnpj());

			statement.executeUpdate();

			System.out.println("<<<iNFO: Prato com do restaurante com CNPJ:"+prato.getCnpj()+", atualizou o prato.>>>");
			return "Atualização do prato foi feito com sucesso!";
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("<<<iNFO: Prato com do restaurante com CNPJ:"+prato.getCnpj()+",não pode cadastrar um novo prato.>>>");
			return "Falha ao atualizar o prato! Tente mais tarde.";
		}		
	}

	@Override
	public String DeletarPrato(Prato prato) {
		String query = "";

		try {
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setInt(1,prato.getId_cardapio());
			statement.execute();

			System.out.println("<<<iNFO: Prato com do restaurante com CNPJ:"+prato.getCnpj()+", deletou um prato prato com id: "+prato.getId_cardapio()+".>>>");
			return "Deleção do prato foi feito com sucesso!";
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("<<<iNFO: Prato com do restaurante com CNPJ:"+prato.getCnpj()+",não pode cadastrar um novo prato com id:"+prato.getId_cardapio()+".>>>");
			return "Falha ao deletar o prato! Tente mais tarde.";
		}	
	}



}
