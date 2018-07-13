package br.com.foodclub.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="prato")
@Entity
public class Prato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_cardapio;
	
	private String nome;
	private String classificacao;
	private Double preco;
	private String tamanho;
	private int disponivel;
	private Double nota; 
	private String cnpj; 

	
	public Prato() {
		super();
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

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public int getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(int disponivel) {
		this.disponivel = disponivel;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Prato(int id_cardapio, String nome, String classificacao, Double preco, String tamanho, int disponivel,
			Double nota, String cnpj) {
		super();
		this.id_cardapio = id_cardapio;
		this.nome = nome;
		this.classificacao = classificacao;
		this.preco = preco;
		this.tamanho = tamanho;
		this.disponivel = disponivel;
		this.nota = nota;
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return "Prato [id_cardapio=" + id_cardapio + ", nome=" + nome + ", classificacao=" + classificacao + ", preco="
				+ preco + ", tamanho=" + tamanho + ", disponivel=" + disponivel + ", nota=" + nota + ", cnpj=" + cnpj
				+ "]";
	}


	

}
