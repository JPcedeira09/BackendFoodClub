package br.com.foodclub.abstracts.service;

import br.com.foodclub.models.Cliente;
import br.com.foodclub.models.GenericResponse;

import java.util.List;

public interface ClienteService {

    public String cadastrar(Cliente cliente);

    public Cliente ataulizar(Cliente cliente);

    public String apagar(String cpf);

    public Cliente buscar(String cpf);

    public List<Cliente> listar();

	public GenericResponse login(String cpf, String senha);

}
