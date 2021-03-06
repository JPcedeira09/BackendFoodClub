package br.com.foodclub.abstracts.dao;

import br.com.foodclub.models.EnderecoCliente;
import br.com.foodclub.models.EnderecoRest;

public interface EnderecoDAO {

    public String CadastrarEnderecoCliente (EnderecoCliente endereco);

    public EnderecoCliente AtualizarEnderecoCliente(EnderecoCliente endereco);

    public EnderecoCliente BuscarEnderecoCliente(Integer id_endereco);

    public String DeletarEnderecoCliente(Integer id_endereco);

    public String CadastrarEnderecoRest(EnderecoRest endereco);

    public EnderecoRest AtualizarEnderecoRest(EnderecoRest endereco);

    public EnderecoRest BuscarEnderecoRest(Integer id_endereco);

    public String DeletarEnderecoRest(Integer id_endereco);

}
