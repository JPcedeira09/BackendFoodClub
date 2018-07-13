package br.com.foodclub.abstracts.service;

import java.util.List;

import br.com.foodclub.models.Prato;
import br.com.foodclub.models.Restaurante;

public interface RestauranteService {
	
    public String cadastrar(Restaurante restaurante);

    public Restaurante atualizar(Restaurante restaurante);

    public Restaurante buscar(String CNPJ);

    public String deletar(String CNPJ);

    public List<Restaurante> buscarLista();

    public List<Prato> ListarCardapio(String CNPJ);

    public Restaurante getByID(String ID);
    
}
