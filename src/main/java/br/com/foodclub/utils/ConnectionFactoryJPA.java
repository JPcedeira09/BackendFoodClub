package br.com.foodclub.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ConnectionFactoryJPA {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("cortana");
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
	/*public static void main(String[] args) {
		System.out.println(ConnectionFactoryJPA.getEntityManager());
	}*/
}
