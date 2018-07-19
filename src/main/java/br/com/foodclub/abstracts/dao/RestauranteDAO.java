package br.com.foodclub.abstracts.dao;

import br.com.foodclub.models.Prato;
import br.com.foodclub.models.Restaurante;

import java.util.List;

public interface RestauranteDAO {

    public String CadastrarRestaurante(Restaurante restaurante);

    public Restaurante AtualizarRestaurante(Restaurante restaurante);

    public Restaurante BuscarRestaurante(String CNPJ);

    public String DeletarRestaurante(String CNPJ);

    public List<Restaurante> BuscarRestaurantes();

    public List<Prato> ListarCardapio(String CNPJ);

}
