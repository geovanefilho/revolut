package com.revolut.demo.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 * Class responsible for keep a single instance of EntityManager
 * 
 * @author geovanefilho
 *
 */
public class EntityManagerHelper {
	private static final EntityManagerFactory emf;
	private static EntityManager em;

	static {
		emf = Persistence.createEntityManagerFactory("test");
	}

	/**
	 * Return the single EntityManager for the system
	 * @return
	 */
	public static EntityManager getEntityManager() {
		if (em == null) {
			em = emf.createEntityManager();
		}
		return em;
	}

	/**
	 * Close the conection whit the entitymanager
	 */
	public static void closeEntityManager() {
		if (em != null) {
			em.close();
		}
	}

	/**
	 * Close the EntityManagerFactory connection
	 */
	public static void closeEntityManagerFactory() {
		emf.close();
	}

	/**
	 * Begin the transaction
	 */
	public static void beginTransaction() {
		getEntityManager().getTransaction().begin();
	}

	/**
	 * Do the rollback
	 */
	public static void rollback() {
		getEntityManager().getTransaction().rollback();
	}

	/**
	 * Commit the changes
	 */
	public static void commit() {
		getEntityManager().getTransaction().commit();
	}
}
