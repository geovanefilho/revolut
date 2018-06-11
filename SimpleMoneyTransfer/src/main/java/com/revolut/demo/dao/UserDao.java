/**
 * 
 */
package com.revolut.demo.dao;

import com.revolut.demo.model.User;

/**
 * 
 * Interface with standard methods that has access to database and the service for User
 * 
 * @author geovanefilho
 *
 */
public interface UserDao extends AbstractDao<User> {

	/**
	 * Find a user by his username
	 * @param username
	 * @return
	 */
	User findByUserName(String username);

}
