package br.com.foodclub.impl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.foodclub.abstracts.dao.EnderecoDAO;
import br.com.foodclub.abstracts.service.EnderecoService;
import br.com.foodclub.models.EnderecoCliente;
import br.com.foodclub.models.EnderecoRest;



@Service
public class EnderecoController implements EnderecoService{

    @Autowired
    private EnderecoDAO dao;
    
	@Override
	public String cadastrarCliente(EnderecoCliente endereco) {
		return dao.CadastrarEnderecoCliente(endereco);
	}

	@Override
	public EnderecoCliente atualizarCliente(EnderecoCliente endereco) {
		return dao.AtualizarEnderecoCliente(endereco);
	}

	@Override
	public EnderecoCliente buscarCliente(Integer id_endereco) {
		return dao.BuscarEnderecoCliente(id_endereco);
	}

	@Override
	public String deletarCliente(Integer id_endereco) {
		return dao.DeletarEnderecoCliente(id_endereco);
	}
	
	@Override
	public String cadastrarRest(EnderecoRest endereco) {
		return dao.CadastrarEnderecoRest(endereco);
	}

	@Override
	public EnderecoRest atualizarRest(EnderecoRest endereco) {
		return dao.AtualizarEnderecoRest(endereco);
	}

	@Override
	public EnderecoRest buscarRest(Integer id_endereco) {
		return dao.BuscarEnderecoRest(id_endereco);
	}

	@Override
	public String deletarRest(Integer id_endereco) {
		return dao.DeletarEnderecoRest(id_endereco);
	}

}
