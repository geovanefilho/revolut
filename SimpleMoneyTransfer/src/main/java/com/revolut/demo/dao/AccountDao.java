package com.revolut.demo.dao;

import com.revolut.demo.model.Account;

/**
 * 
 * Interface with standard methods that has access to database and the service for Account
 * 
 * @author geovanefilho
 *
 */
public interface AccountDao extends AbstractDao<Account> {

	/**
	 * Find an account by his number
	 * 
	 * @param number
	 * @return
	 */
	Account findByNumer(String number);

}
