package br.com.foodclub.abstracts.service;

import br.com.foodclub.models.EnderecoCliente;
import br.com.foodclub.models.EnderecoRest;

public interface EnderecoService {

	String cadastrarCliente(EnderecoCliente endereco);

	EnderecoCliente atualizarCliente(EnderecoCliente endereco);

	EnderecoCliente buscarCliente(String id_endereco);

	String deletarCliente(String id_endereco);

	EnderecoRest buscarRest(String id_endereco);

	String deletarRest(String id_endereco);

	EnderecoRest atualizarRest(EnderecoRest endereco);

	String cadastrarRest(EnderecoRest endereco);

}
