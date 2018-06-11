/**
 * 
 */
package com.revolut.demo.service.impl;

import java.util.Collection;

import com.revolut.demo.dao.AbstractDao;
import com.revolut.demo.dao.impl.DemoDaoImpl;
import com.revolut.demo.service.AbstractService;

/**
 * 
 * Abstract class whit implementations of the standard methods
 * 
 * @author geovanefilho
 * @param <T>
 *
 */
public abstract class DemoServiceImpl<T> implements AbstractService<T> {
	
	private AbstractDao<T> genericDao;

	public DemoServiceImpl(AbstractDao<T> genericDao) {
		super();
		if (genericDao != null) {
			this.genericDao = genericDao;
		} else {
			this.genericDao = new DemoDaoImpl<T>();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public T save(T model) throws Exception {
		return genericDao.save(model);
	};
	
	/**
	 * {@inheritDoc}
	 */
	public T merge(T model) {
		return genericDao.merge(model);
	};
	
	/**
	 * {@inheritDoc}
	 */
	public boolean delete(T model) {
		return genericDao.delete(model);
	};
	
	/**
	 * {@inheritDoc}
	 */
	public T find(Class<T> clazz, Long id) {
		return genericDao.find(clazz, id);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Collection<T> findAll(Class<T> clazz) {
		return genericDao.findAll(clazz);
	}
}
