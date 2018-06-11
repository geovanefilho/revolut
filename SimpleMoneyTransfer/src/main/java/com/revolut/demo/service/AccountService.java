/**
 * 
 */
package com.revolut.demo.service;

import java.math.BigDecimal;

import com.revolut.demo.model.Account;

/**
 * @author geovanefilho
 *
 */
public interface AccountService extends AbstractService<Account> {

	public void debit(Account account, BigDecimal amount) throws Exception;
	
	public void credit(Account account, BigDecimal amount) throws Exception;
	
	public Account findByNumber(String number);
	
}
