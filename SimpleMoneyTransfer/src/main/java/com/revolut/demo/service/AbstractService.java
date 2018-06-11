/**
 * 
 */
package com.revolut.demo.service;

import java.util.Collection;

/**
 * 
 * An abstract interface service whit some standard methods
 * 
 * @author geovanefilho
 *
 */
public abstract interface AbstractService<T> {	

	/**
	 * 
	 * Method to save a model
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public T save(T model) throws Exception;
	
	/**
	 * Method to update a model
	 * 
	 * @param model
	 * @return
	 */
	public T merge(T model);
	
	/**
	 * Method to delete a model
	 * 
	 * @param model
	 * @return
	 */
	public boolean delete(T model);
	
	/**
	 * Method to find a model with his class and primary key
	 * @param clazz
	 * @param id
	 * @return
	 */
	public T find(Class<T> clazz, Long id);
	
	/**
	 * Method to find all models in the database
	 * 
	 * @param clazz
	 * @return
	 */
	public Collection<T> findAll(Class<T> clazz);
	
}
