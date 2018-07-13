package br.com.foodclub.impl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.foodclub.abstracts.dao.ClienteDAO;
import br.com.foodclub.abstracts.service.ClienteService;
import br.com.foodclub.models.Cliente;
import br.com.foodclub.models.GenericResponse;

@Service
public class ClienteController implements ClienteService {

    @Autowired
    private ClienteDAO dao;

    public String cadastrar(Cliente cliente) {
        return dao.cadastrarCliente(cliente);
    }

    public Cliente ataulizar(Cliente cliente) {
        return dao.atualizarCadastroCliente(cliente);
    }

    public String apagar(String cpf ) {
        return dao.apagarCadastroCliente(cpf);
    }

    public Cliente buscar(String cpf) {
        return dao.buscarCliente(cpf);
    }

    public List<Cliente> listar() {
        return dao.buscarClientes();
    }

	@Override
	public GenericResponse login(String cpf, String senha) {
		// TODO Auto-generated method stub
		return dao.login(cpf,senha);
	}

}
