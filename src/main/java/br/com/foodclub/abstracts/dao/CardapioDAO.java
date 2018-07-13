package br.com.foodclub.abstracts.dao;

import br.com.foodclub.models.Prato;

import java.util.List;

public interface CardapioDAO {

    public String CadastrarPrato(Prato prato);

    public String AtualizarPrato(Prato prato);

    public String DeletarPrato(Prato prato);

    public Prato BuscarPrato(int id_cardapio);

    public List<Prato> BuscarPratos(String CNPJ);
}
