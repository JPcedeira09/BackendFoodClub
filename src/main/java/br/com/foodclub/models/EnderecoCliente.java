package br.com.foodclub.models;

import com.google.gson.Gson;

public class EnderecoCliente {

	private Integer id_enderecos;
	private String CEP;
	private String bairro;
	private String cidade;
	private String estado;
	private String cpf;
	private String rua;
	private String complemento;


	public Integer getId_enderecos() {
		return id_enderecos;
	}

	public void setId_enderecos(Integer id_enderecos) {
		this.id_enderecos = id_enderecos;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String CEP) {
		this.CEP = CEP;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public EnderecoCliente() {
		super();
	}

	public EnderecoCliente(Integer id_enderecos, String cEP, String bairro, String cidade, String estado, String cpf,
			String rua, String complemento) {
		super();
		this.id_enderecos = id_enderecos;
		this.CEP = cEP;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cpf = cpf;
		this.rua = rua;
		this.complemento = complemento;
	}

	@Override
	public String toString() {
		return "EnderecoCliente [id_enderecos=" + id_enderecos + ", CEP=" + CEP + ", bairro=" + bairro + ", cidade="
				+ cidade + ", estado=" + estado + ", cpf=" + cpf + ", rua=" + rua + ", complemento=" + complemento
				+ "]";
	}

	public String toJSON() {
		return new Gson().toJson(this);
	}
}
