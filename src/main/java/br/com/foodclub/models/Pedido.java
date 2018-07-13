package br.com.foodclub.models;

import java.util.Calendar;

public class Pedido {

	private int id_pedidos;
	private Calendar tempo_de_entrega;
	private double valor;
	private String cpf;
	private String cnpj;

	public int getId_pedidos() {
		return id_pedidos;
	}
	public void setId_pedidos(int id_pedidos) {
		this.id_pedidos = id_pedidos;
	}
	public Calendar getTempo_de_entrega() {
		return tempo_de_entrega;
	}
	public void setTempo_de_entrega(Calendar tempo_de_entrega) {
		this.tempo_de_entrega = tempo_de_entrega;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getCPF() {
		return cpf;
	}
	public void setCPF(String cpf) {
		this.cpf = cpf;
	}
	public String getCNPJ() {
		return cnpj;
	}
	public void setCNPJ(String cnpj) {
		this.cnpj = cnpj;
	}

	public Pedido(int id_pedidos, Calendar tempo_de_entrega, double valor, String cpf, String cnpj) {
		super();
		this.id_pedidos = id_pedidos;
		this.tempo_de_entrega = tempo_de_entrega;
		this.valor = valor;
		this.cpf = cpf;
		this.cnpj = cnpj;
	}	

}
