/**
 * 
 */
package com.revolut.demo.service;

import java.math.BigDecimal;

import com.revolut.demo.model.Account;
import com.revolut.demo.model.Transfer;

/**
 * 
 * A service interface to transfer amounts between accounts
 * 
 * @author geovanefilho
 *
 */
public interface TransferService extends AbstractService<Transfer> {

	/**
	 * Method to do a transfer between accounts
	 * 
	 * @param origin
	 * @param destiny
	 * @param amount
	 * @return
	 * @throws Exception
	 */
	public Transfer transfer(Account origin, Account destiny, BigDecimal amount) throws Exception;
	
}
