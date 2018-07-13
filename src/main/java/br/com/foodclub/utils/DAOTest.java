package br.com.foodclub.utils;


import br.com.foodclub.impl.db.ClienteDB;
import br.com.foodclub.models.Cliente;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DAOTest {


    private ClienteDB dao;
    private Cliente cliente;

    @Before
    public void contrutores(){
        dao = new ClienteDB();
        cliente = new Cliente( "461.878.878.98",  "Johnny Bravo",  "tesstando",  "(11)99336-0316",  "(11)4232-3142",  "jp.bravo@gmail.com");
    }

    @Test
    public void testandoCadastro(){
System.out.println("teste 1");
        String respostaCadastrar = dao.cadastrarCliente(cliente);
        Assert.assertEquals("Cadastro efetuado com sucesso! Bem vindo!!!", respostaCadastrar);
    }

    @Test
    public void testandoAtualizacao(){
    	System.out.println("teste 2");

        cliente.setNome("El Johnny Bravo");
        dao.atualizarCadastroCliente(cliente);
        Cliente clienteRetorno = dao.buscarCliente(cliente.getcpf());
        Assert.assertEquals("El Johnny Bravo", clienteRetorno.getNome());
    }

    @After
    public void testandoDelete(){
    	System.out.println("teste 3");
        String respostaApagar = dao.apagarCadastroCliente(cliente.getcpf());
        Assert.assertEquals("Cadastro deletado com sucesso! Adeus!!!", respostaApagar);
    }

}
