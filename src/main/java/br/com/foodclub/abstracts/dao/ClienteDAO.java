package br.com.foodclub.abstracts.dao;

import br.com.foodclub.models.Cliente;
import br.com.foodclub.models.GenericResponse;

import java.util.List;

public interface ClienteDAO {

    public String cadastrarCliente(Cliente cliente);

    public Cliente atualizarCadastroCliente(Cliente cliente);

    public String apagarCadastroCliente(String cpf);

    public Cliente buscarCliente(String cpf);

    public List<Cliente> buscarClientes();

	public GenericResponse login(String cpf, String senha);
}
