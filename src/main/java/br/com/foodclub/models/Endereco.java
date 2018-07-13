package br.com.foodclub.models;

public class Endereco {

	private int id_enderecos;
	private String CEP;
	private String rua;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;

	public Endereco() {
		super();
	}

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
		this.CEP = cEP;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
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

	public Endereco(int id_enderecos, String cEP, String rua, String complemento, String bairro, String cidade,
			String estado) {
		super();
		this.id_enderecos = id_enderecos;
		this.CEP = cEP;
		this.rua = rua;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	
}
