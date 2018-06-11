package com.revolut.demo.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import com.revolut.demo.dao.AbstractDao;

/**
 * @author geovanefilho
 * @param <T>
 *
 */
public class DemoDaoImpl<T> implements AbstractDao<T> {
	
	public DemoDaoImpl() {
		super();
	}

	public T save(T model) {
		EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
		
		try {
			t.begin();
			
			EntityManagerHelper.getEntityManager().persist(model);
			
			t.commit();
		} catch (PersistenceException e) {
			t.rollback();
			throw e;
		}
		
		return model;
	};
	
	public T merge(T model) {
		EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
		
		try {
			t.begin();
			
			EntityManagerHelper.getEntityManager().merge(model);
			
			t.commit();
		} catch (PersistenceException e) {
			t.rollback();
			throw e;
		}
		
		return model;
	};
	
	public boolean delete(T model) {
		EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
		try {
			t.begin();
			
			EntityManagerHelper.getEntityManager().remove(model);
			
			t.commit();
		} catch (PersistenceException e) {
			t.rollback();
			throw e;
		}
		
		return true;
	};
	
	public T find(Class<T> clazz, Long id) {
		T obj = (T) EntityManagerHelper.getEntityManager().find(clazz, id);
		return obj;
	}

	@Override
	public Collection<T> findAll(Class<T> clazz) {
		List<T> resultList = EntityManagerHelper.getEntityManager().createQuery("Select u from " + clazz.getSimpleName() + " u", clazz).getResultList();
		return resultList;
	}
	
}
