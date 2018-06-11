/**
 * 
 */
package com.revolut.demo.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.revolut.demo.dao.AccountDao;
import com.revolut.demo.dao.impl.AccountDaoImpl;
import com.revolut.demo.model.Account;
import com.revolut.demo.service.AccountService;

/**
 * 
 * Implementation service for the methods of account
 * 
 * @author geovanefilho
 *
 */
public class AccountServiceImpl extends DemoServiceImpl<Account> implements AccountService {

	private static final int EQUAL_VALUE = 0;
	private AccountDao accountDao;
	
	public AccountServiceImpl(AccountDao accountDao) {
		super(accountDao);
		if (accountDao == null) {
			this.accountDao = new AccountDaoImpl();
			accountDao = this.accountDao;
		}
	}
	
	/**
	 * {@inheritDoc}
	 * @throws Exception 
	 */
	@Override
	public void debit(Account account, BigDecimal amount) throws Exception {
		validate(account, amount);
		
		account = this.accountDao.find(Account.class, account.getId());
		if (account.getBalance().compareTo(amount) < EQUAL_VALUE) {
			throw new Exception("You do not have enough balance to do this request! Balance: " + account.getBalance().setScale(2, RoundingMode.HALF_UP) + " " + account.getCurrency());
		} else {
			account.debit(amount);
			this.accountDao.merge(account);
		}
	}

	/**
	 * {@inheritDoc}
	 * @throws Exception 
	 */
	@Override
	public void credit(Account account, BigDecimal amount) throws Exception {
		validate(account, amount);
		
		account = this.accountDao.find(Account.class, account.getId());
		account.credit(amount);
		this.accountDao.merge(account);
	}
	
	/**
	 * Validate the information necessary to do operations in accounts
	 * 
	 * @param account
	 * @param amount
	 * @throws Exception
	 */
	private void validate(Account account, BigDecimal amount) throws Exception {
		if (account == null || account.getId() == null) {
			throw new Exception("You have to select a valid account!");
		}
		
		if (amount == null || amount.compareTo(BigDecimal.ZERO) <= EQUAL_VALUE) {
			throw new Exception("The amount field is required and needs to be higher than zero!");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Account findByNumber(String number) {
		return this.accountDao.findByNumer(number);
	}

}
