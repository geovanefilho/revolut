/**
 * 
 */
package com.revolut.demo.dao;

import com.revolut.demo.model.User;

/**
 * @author geovanefilho
 *
 */
public interface UserDao extends AbstractDao<User> {

	User findByUserName(String username);

}
