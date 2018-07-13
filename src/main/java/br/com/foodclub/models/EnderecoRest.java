package br.com.foodclub.models;

public class EnderecoRest {
	private int id_enderecos;
	private String CEP;
	private String bairro;
	private String cidade;
	private String estado;
	private String cnpj;
	
	public int getId_enderecos() {
		return id_enderecos;
	}
	public void setId_enderecos(int id_enderecos) {
		this.id_enderecos = id_enderecos;
	}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	@Override
	public String toString() {
		return "EnderecoEnd [id_enderecos=" + id_enderecos + ", CEP=" + CEP + ", bairro=" + bairro + ", cidade="
				+ cidade + ", estado=" + estado + ", cnpj=" + cnpj + "]";
	}
	public EnderecoRest(int id_enderecos, String cEP, String bairro, String cidade, String estado, String cnpj) {
		super();
		this.id_enderecos = id_enderecos;
		CEP = cEP;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cnpj = cnpj;
	}
	public EnderecoRest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
