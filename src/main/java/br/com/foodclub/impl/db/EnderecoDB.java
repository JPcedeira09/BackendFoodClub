package br.com.foodclub.impl.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import br.com.foodclub.abstracts.dao.EnderecoDAO;
import br.com.foodclub.models.EnderecoCliente;
import br.com.foodclub.models.EnderecoRest;
import br.com.foodclub.utils.ConnectionFactory;

@Repository
public class EnderecoDB implements EnderecoDAO{

	private Connection connection;

	public EnderecoDB() {
		this.connection = ConnectionFactory.getConnection();
	}

	@Override
	public String CadastrarEnderecoCliente(EnderecoCliente endereco) {

		String query = "INSERT INTO mydb.endereco_cliente (CEP, bairro, cidade, estado, cpf, rua, complemento) VALUES (?,?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setString(1, endereco.getCEP());
			statement.setString(2, endereco.getBairro());
			statement.setString(3, endereco.getCidade());
			statement.setString(4, endereco.getEstado());
			statement.setString(5, endereco.getCpf());
			statement.setString(6, endereco.getRua());
			statement.setString(7, (endereco.getComplemento().isEmpty() ? "nenhum" : endereco.getComplemento()));

			statement.execute();

			System.out.println("<<<iNFO: Cadastro de endereço com CPF/CNPJ:"+endereco.getCpf()+", efetuado.>>>");
			return "Cadastro do endereço efetuado com sucesso! Bem vindo!!!";

		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("<<<iNFO: Cadastro de endereço com CPF/CNPJ:"+endereco.getCpf()+", não foi efetuado.>>>");
			return "Falha ao efetuar o cadastro do endereço! Tente mais tarde.";
		}
	}

	@Override
	public EnderecoCliente AtualizarEnderecoCliente(EnderecoCliente endereco) {

		String query = "UPDATE mydb.endereco_cliente SET CEP = ?, bairro = ?, cidade = ?, estado = ? , rua = ? , complemento = ? WHERE id_enderecos = ? and cpf = ?";		
		try {
			PreparedStatement statement = this.connection.prepareStatement(query);

			statement.setString(1, endereco.getCEP());
			statement.setString(2, endereco.getBairro());
			statement.setString(3, endereco.getCidade());
			statement.setString(4, endereco.getEstado());
			statement.setString(5, endereco.getRua());
			statement.setString(6, endereco.getComplemento());
			statement.setInt(7, endereco.getId_enderecos());
			statement.setString(8, endereco.getCpf());

			statement.execute();

			System.out.println("<<<iNFO: Cadastro de endereço com CPF/CNPJ:"+endereco.getCpf()+"/"+endereco.getCpf()+", atulizou o cadastro do endereço.>>>");
			return endereco;

		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("<<<iNFO: Cadastro de endereço com CPF/CNPJ:"+endereco.getCpf()+"/"+endereco.getCpf()+", não atulizou o cadastro do endereço.>>>");
			return null ;
		}
	}

	@Override
	public EnderecoCliente BuscarEnderecoCliente(String id_endereco) {

		String query = "SELECT * FROM mydb.endereco_cliente where id_enderecos = ? ";
		EnderecoCliente endereco = new EnderecoCliente();

		try {
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setString(1, id_endereco);
			ResultSet set = statement.executeQuery();
			while(set.next()) {
				endereco.setId_enderecos(set.getInt("id_enderecos"));
				endereco.setCEP(set.getString("CEP"));
				endereco.setBairro(set.getString("bairro"));
				endereco.setCidade(set.getString("cidade"));
				endereco.setEstado(set.getString("estado"));
				endereco.setCpf(set.getString("cpf"));
				endereco.setRua(set.getString("rua"));
				endereco.setComplemento(set.getString("complemento"));
			}
			return endereco;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("<<<iNFO: Cadastro de  com cpf:"+endereco.getCpf()+", não conseguiu fazer um get no endereço.>>>");
			return null;
		}
	}

	@Override
	public String DeletarEnderecoCliente(String id_endereco) {
		String query = "DELETE FROM mydb.endereco_cliente WHERE id_enderecos= ?";

		try {
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setString(1, id_endereco);
			statement.execute();
			
			System.out.println("<<<iNFO: Cadastro com id:"+id_endereco+", deletou o endereço.>>>");
			return "Endereço deletado com sucesso! Adeus!!!";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("<<<iNFO: Cadastro com cpf:"+id_endereco+", não conseguiu deletar o endereço.>>>");
			return "Falha ao deletar o endereço! Tente mais tarde.";
		}		
	}

	@Override
	public String CadastrarEnderecoRest(EnderecoRest endereco) {
		String query = "INSERT INTO mydb.endereco_rest (CEP, bairro, cidade, estado, cnpj) VALUES (?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setString(1, endereco.getCEP());
			statement.setString(2, endereco.getBairro());
			statement.setString(3, endereco.getCidade());
			statement.setString(4, endereco.getEstado());
			statement.setString(5, endereco.getCnpj());

			statement.execute();

			System.out.println("<<<iNFO: Cadastro de endereço com CPF/CNPJ:"+endereco.getCnpj()+", efetuado.>>>");
			return "Cadastro do endereço efetuado com sucesso! Bem vindo!!!";

		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("<<<iNFO: Cadastro de endereço com CPF/CNPJ:"+endereco.getCnpj()+", não foi efetuado.>>>");
			return "Falha ao efetuar o cadastro do endereço! Tente mais tarde.";
		}
	}

	@Override
	public EnderecoRest AtualizarEnderecoRest(EnderecoRest endereco) {
		String query = "UPDATE mydb.endereco_rest SET CEP = ?, bairro = ?, cidade = ?, estado = ? WHERE id_enderecos = ? ";		
		try {
			PreparedStatement statement = this.connection.prepareStatement(query);

			statement.setString(1, endereco.getCEP());
			statement.setString(2, endereco.getBairro());
			statement.setString(3, endereco.getCidade());
			statement.setString(4, endereco.getEstado());
			statement.setString(5, endereco.getCnpj());

			statement.execute();

			System.out.println("<<<iNFO: Cadastro de endereço com CPF/CNPJ:"+endereco.getCnpj()+", atulizou o cadastro do endereço.>>>");
			return endereco;

		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("<<<iNFO: Cadastro de endereço com CPF/CNPJ:"+endereco.getCnpj()+", não atulizou o cadastro do endereço.>>>");
			return null ;
		}
	}

	@Override
	public EnderecoRest BuscarEnderecoRest(String id_endereco) {
		String query = "SELECT * FROM mydb.endereco_rest where id_enderecos = ? ";
		EnderecoRest endereco = new EnderecoRest();

		try {
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setString(1, id_endereco);
			ResultSet set = statement.executeQuery();
			while(set.next()) {
				endereco.setId_enderecos(set.getInt("id_enderecos"));
				endereco.setCEP(set.getString("CEP"));
				endereco.setBairro(set.getString("bairro"));
				endereco.setCidade(set.getString("cidade"));
				endereco.setEstado(set.getString("estado"));
				endereco.setCnpj(set.getString("cnpj"));
			}
			return endereco;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("<<<iNFO: Cadastro de  com cnpj:"+endereco.getCnpj()+", não conseguiu fazer um get no endereço.>>>");
			return null;
		}
	}

	@Override
	public String DeletarEnderecoRest(String id_endereco) {
		String query = "DELETE FROM mydb.endereco_rest WHERE id_enderecos= ?";

		try {
			PreparedStatement statement = this.connection.prepareStatement(query);
			statement.setString(1, id_endereco);
			statement.execute();
			
			System.out.println("<<<iNFO: Cadastro com id:"+id_endereco+", deletou o endereço.>>>");
			return "Endereço deletado com sucesso! Adeus!!!";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("<<<iNFO: Cadastro com cnpj:"+id_endereco+", não conseguiu deletar o endereço.>>>");
			return "Falha ao deletar o endereço! Tente mais tarde.";
		}	
	}
 
}
