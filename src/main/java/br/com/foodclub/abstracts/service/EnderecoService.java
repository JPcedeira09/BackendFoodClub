package br.com.foodclub.abstracts.service;

import br.com.foodclub.models.EnderecoCliente;
import br.com.foodclub.models.EnderecoRest;

public interface EnderecoService {

	String cadastrarCliente(EnderecoCliente endereco);

	EnderecoCliente atualizarCliente(EnderecoCliente endereco);

	EnderecoCliente buscarCliente(Integer id_endereco);

	String deletarCliente(Integer id_endereco);

	EnderecoRest buscarRest(Integer id_endereco);

	String deletarRest(Integer id_endereco);

	EnderecoRest atualizarRest(EnderecoRest endereco);

	String cadastrarRest(EnderecoRest endereco);

}
