package br.com.foodclub.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.Gson;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@Column(name = "cpf", nullable = false)
	private String cpf;

	@Column(name = "nome", nullable = false)
	private String nome; 

	@Column(name = "senha", nullable = false)
	private String senha; 

	@Column(name = "telefone", nullable = false)
	private String cel; 

	@Column(name = "cel", nullable = false)
	private String telefone;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "endereco", nullable = false)
	private EnderecoCliente endereco;

	public String getcpf() {
		if(cpf != null) {
		return cpf;}
		else {
			return "";
		}
	}

	public void setcpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCel() {
		return cel;
	}

	public void setCel(String cel) {
		this.cel = cel;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EnderecoCliente getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoCliente endereco) {
		this.endereco = endereco;
	}



	@Override
	public String toString() {
		return cpf + ";" + nome + ";" + senha + ";" + cel + ";" + telefone + ";" + email + ";" + endereco;
	}

	public Cliente(String cpf, String nome, String senha, String cel, String telefone, String email) {
		super();

		this.cpf = cpf;
		this.nome = nome;
		this.senha = senha;
		this.cel = cel;
		this.telefone = telefone;
		this.email = email;
	}

	public Cliente() {
		super();
	}
	
	public String toJSON() {
		return new Gson().toJson(this);
	}

}
