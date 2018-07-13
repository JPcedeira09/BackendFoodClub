package br.com.foodclub.models;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="restaurantes")
@Entity
public class Restaurante {

	@Id
	private String cnpj;
	
	private int id_endereco;
	private int id_cardapio;
	private String nome;
	private String senha;
	private String telefone;
	private String email;
	private String classificacao;
	private int entrega;
	private Double avaliacao;
	private Blob imgViewLogo;
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public int getid_endereco() {
		return id_endereco;
	}
	public void setid_endereco(int id_endereco) {
		this.id_endereco = id_endereco;
	}
	public int getId_cardapio() {
		return id_cardapio;
	}
	public void setId_cardapio(int id_cardapio) {
		this.id_cardapio = id_cardapio;
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
	public String getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	public int getEntrega() {
		return entrega;
	}
	public void setEntrega(int entrega) {
		this.entrega = entrega;
	}
	public Double getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(Double avaliacao) {
		this.avaliacao = avaliacao;
	}
	public Blob getImgViewLogo() {
		return imgViewLogo;
	}
	public void setImgViewLogo(Blob imgViewLogo) {
		this.imgViewLogo = imgViewLogo;
	}
	
	public Restaurante(String cnpj, int id_endereco, int id_cardapio, String nome, String senha, String telefone,
			String email, String classificacao, int entrega, Double avaliacao, Blob imgViewLogo) {
		super();
		this.cnpj = cnpj;
		this.id_endereco = id_endereco;
		this.id_cardapio = id_cardapio;
		this.nome = nome;
		this.senha = senha;
		this.telefone = telefone;
		this.email = email;
		this.classificacao = classificacao;
		this.entrega = entrega;
		this.avaliacao = avaliacao;
		this.imgViewLogo = imgViewLogo;
	}
	
	public Restaurante(String cnpj, String nome, String senha, String telefone,
			String email, String classificacao, int entrega, Double avaliacao, Blob imgViewLogo) {
		super();
		this.cnpj = cnpj;
		this.nome = nome;
		this.senha = senha;
		this.telefone = telefone;
		this.email = email;
		this.classificacao = classificacao;
		this.entrega = entrega;
		this.avaliacao = avaliacao;
		this.imgViewLogo = imgViewLogo;
	}
	
	public Restaurante() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Restaurante [cnpj=" + cnpj + ", id_endereco=" + id_endereco + ", id_cardapio=" + id_cardapio
				+ ", nome=" + nome + ", senha=" + senha + ", telefone=" + telefone + ", email=" + email
				+ ", classificacao=" + classificacao + ", entrega=" + entrega + ", avaliacao=" + avaliacao
				+ ", imgViewLogo=" + imgViewLogo + "]";
	}
	
    /*
	public String toJson() {
		return new Gson().toJson(this);
	}
	public static void main(String[] args) {
		
		Restaurante rest = new Restaurante("461.878.999-78", "Vai de Salada", "123456", "4232-3142", "vaidesalada@salada.com.br", "saudavel", 1, 5.0, null);
		
		System.out.println(rest.toString());
		
	}*/

}
