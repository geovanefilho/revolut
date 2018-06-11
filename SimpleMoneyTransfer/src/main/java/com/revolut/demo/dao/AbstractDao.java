package com.revolut.demo.dao;

import java.util.Collection;

/**
 * 
 * Abstract interface that has standards methods.
 * 
 * @author geovanefilho
 *
 * @param <T>
 */
public abstract interface AbstractDao<T> {

	/**
	 * Method to save a model
	 * 
	 * @param model
	 * @return
	 */
	public T save(T model);
	
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
	 * Find a model by his class and primary key
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	public T find(Class<T> clazz, Long id);

	/**
	 * Find all models save in the database
	 * 
	 * @param clazz
	 * @return
	 */
	public Collection<T> findAll(Class<T> clazz);
	
}
