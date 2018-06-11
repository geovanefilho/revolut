/**
 * 
 */
package com.revolut.demo.service.impl;

import java.util.Collection;

import com.revolut.demo.dao.AbstractDao;
import com.revolut.demo.dao.impl.DemoDaoImpl;
import com.revolut.demo.service.AbstractService;

/**
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

	public T save(T model) throws Exception {
		return genericDao.save(model);
	};
	
	public T merge(T model) {
		return genericDao.merge(model);
	};
	
	public boolean delete(T model) {
		return genericDao.delete(model);
	};
	
	public T find(Class<T> clazz, Long id) {
		return genericDao.find(clazz, id);
	}
	
	public Collection<T> findAll(Class<T> clazz) {
		return genericDao.findAll(clazz);
	}
}
