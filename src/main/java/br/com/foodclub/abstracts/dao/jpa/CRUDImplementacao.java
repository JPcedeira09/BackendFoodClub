package br.com.foodclub.abstracts.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.foodclub.utils.ConnectionFactoryJPA;

@Repository
public abstract class CRUDImplementacao <T,K> implements CRUDJPA<T, K>{

	private EntityManager em ;

	private Class<T> clazz;

	// para objetivos de utilizar em cima apenas do hibernate;
	// Session session = em.unwrap(Session.class);

	public CRUDImplementacao(Class<T> clazzToSet) {
		this.clazz = clazzToSet;
		this.em = ConnectionFactoryJPA.getEntityManager();
	}

	@Override
	public void persist(T objeto) {
		em.persist(objeto);
	}

	@Override
	public void delete(T objeto) {
		em.remove(objeto);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(T objeto) {
		List<T> list = em.createQuery( "from " + clazz).getResultList();
		return list;
	}

	@Override
	public T getByID(K ID) {
		T obj = em.find(clazz, ID);
		return obj;
	}
	
	@Override
	public T update(T objeto,K ID) {
		T obj = em.find(clazz, ID);

		T objUpdated = em.merge(obj);
		return objUpdated;
	}

	@Override
	public void deleteById( K ID ){
		T entity =em.find(clazz, ID);
		delete( entity );
	}
}
