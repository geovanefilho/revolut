/**
 * 
 */
package com.revolut.demo.service;

import com.revolut.demo.model.User;

/**
 * 
 * A service interface whit methods to manage users
 * 
 * @author geovanefilho
 *
 */
public interface UserService extends AbstractService<User> {

	/**
	 * Find an user by his username
	 * 
	 * @param userName
	 * @return
	 */
	User findByUserName(String userName);
	
}
