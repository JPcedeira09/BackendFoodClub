package br.com.foodclub.abstracts.dao.jpa;

import java.util.List;

public interface CRUDJPA <T,K>{

	public void persist(T objeto);
	public T update(T objeto,K ID);
	public void delete(T objeto);
	public T getByID( K ID);
	public List<T> getAll(T objeto);
	public void deleteById( K ID );

}
