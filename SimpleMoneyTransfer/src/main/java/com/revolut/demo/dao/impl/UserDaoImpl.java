/**
 * 
 */
package com.revolut.demo.dao.impl;

import java.util.List;

import com.revolut.demo.dao.UserDao;
import com.revolut.demo.model.User;

/**
 * 
 * Implementation class for the methods of the connection whit the database for the service of user
 * 
 * @author geovanefilho
 *
 */
public class UserDaoImpl extends DemoDaoImpl<User> implements UserDao {

	private static final int FIRST_ELEMENT = 0;

	/**
	 * {@inheritDoc}
	 */
	public User findByUserName(String username) {
		List<User> users = EntityManagerHelper.getEntityManager().createQuery("Select u from " + User.class.getSimpleName() + " u WHERE u.username = '" + username + "'", User.class).getResultList();
		if (users.isEmpty()) {
			return null;
		} else {
			return users.get(FIRST_ELEMENT);
		}
	}

}
