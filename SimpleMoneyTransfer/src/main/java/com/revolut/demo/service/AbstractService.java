/**
 * 
 */
package com.revolut.demo.service;

import java.util.Collection;

/**
 * @author geovanefilho
 *
 */
public abstract interface AbstractService<T> {	

	public T save(T model) throws Exception;
	
	public T merge(T model);
	
	public boolean delete(T model);
	
	public T find(Class<T> clazz, Long id);
	
	public Collection<T> findAll(Class<T> clazz);
	
}
