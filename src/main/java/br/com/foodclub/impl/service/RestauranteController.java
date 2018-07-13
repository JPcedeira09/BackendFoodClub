package br.com.foodclub.impl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.foodclub.abstracts.dao.RestauranteDAO;
import br.com.foodclub.abstracts.service.RestauranteService;
import br.com.foodclub.models.Prato;
import br.com.foodclub.models.Restaurante;

@Service
public class RestauranteController implements RestauranteService{

	@Autowired
	private RestauranteDAO dao;

	
	public String cadastrar(Restaurante restaurante) {
		return dao.CadastrarRestaurante(restaurante);
	}

	@Override
	public Restaurante atualizar(Restaurante restaurante) {
		return dao.AtualizarRestaurante(restaurante);
	}

	@Override
	public Restaurante buscar(String CNPJ) {
		return dao.BuscarRestaurante(CNPJ);
	}

	@Override
	public String deletar(String CNPJ) {
		return dao.DeletarRestaurante(CNPJ);
	}

	@Override
	public List<Restaurante> buscarLista() {
		return dao.BuscarRestaurantes();
	}

	@Override
	public List<Prato> ListarCardapio(String CNPJ) {
		return dao.ListarCardapio(CNPJ);
	}

	@Override
	public Restaurante getByID(String ID) {
		return dao.getByCode(ID);
	}

}
