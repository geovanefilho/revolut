/**
 * 
 */
package com.revolut.demo.service;

import java.math.BigDecimal;

import com.revolut.demo.model.Account;

/**
 * 
 * An interface service whit some standard methods for Account
 * 
 * @author geovanefilho
 *
 */
public interface AccountService extends AbstractService<Account> {

	/**
	 * Debit an amount in an account
	 * 
	 * @param account
	 * @param amount
	 * @throws Exception
	 */
	public void debit(Account account, BigDecimal amount) throws Exception;
	
	/**
	 * Credit an amount in an account
	 * 
	 * @param account
	 * @param amount
	 * @throws Exception
	 */
	public void credit(Account account, BigDecimal amount) throws Exception;
	
	/**
	 * Find an account by its number
	 * 
	 * @param number
	 * @return
	 */
	public Account findByNumber(String number);
	
}
