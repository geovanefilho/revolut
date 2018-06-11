package com.revolut.demo.dao;

import java.util.Collection;

public abstract interface AbstractDao<T> {

	public T save(T model);
	
	public T merge(T model);
	
	public boolean delete(T model);
	
	public T find(Class<T> clazz, Long id);

	public Collection<T> findAll(Class<T> clazz);
	
}
