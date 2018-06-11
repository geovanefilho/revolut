/**
 * 
 */
package com.revolut.demo.service;

import java.math.BigDecimal;

import com.revolut.demo.model.Account;
import com.revolut.demo.model.Transfer;

/**
 * @author geovanefilho
 *
 */
public interface TransferService extends AbstractService<Transfer> {

	public Transfer transfer(Account origin, Account destiny, BigDecimal amount) throws Exception;
	
}
