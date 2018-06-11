/**
 * 
 */
package com.revolut.demo.service;

import com.revolut.demo.model.User;

/**
 * @author geovanefilho
 *
 */
public interface UserService extends AbstractService<User> {

	User findByUserName(String userName);
	
}
