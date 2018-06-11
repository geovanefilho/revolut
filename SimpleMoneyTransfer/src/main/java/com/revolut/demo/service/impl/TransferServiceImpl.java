/**
 * 
 */
package com.revolut.demo.service.impl;

import java.math.BigDecimal;

import com.revolut.demo.dao.TransferDao;
import com.revolut.demo.dao.impl.TransferDaoImpl;
import com.revolut.demo.model.Account;
import com.revolut.demo.model.Transfer;
import com.revolut.demo.service.AccountService;
import com.revolut.demo.service.ExchangeRateService;
import com.revolut.demo.service.TransferService;

/**
 * @author geovanefilho
 *
 */
public class TransferServiceImpl extends DemoServiceImpl<Transfer> implements TransferService {
	
	private static final int EQUAL_VALUE = 0;
	private TransferDao transferDao;
	private ExchangeRateService exchangeRateService;
	private AccountService accountService;
	
	public TransferServiceImpl(TransferDao transferDao) {
		super(transferDao);
		if (transferDao != null) {
			this.transferDao = transferDao;
		} else {
			transferDao = new TransferDaoImpl();
			this.transferDao = transferDao;
		}
		this.exchangeRateService = new ExchangeRateServiceImpl();
		this.accountService = new AccountServiceImpl(null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Transfer transfer(Account origin, Account destiny, BigDecimal amount) throws Exception {
		Transfer transfer = new Transfer(origin, destiny, amount);
		validate(transfer);
		
		BigDecimal exchangeRate = exchangeRateService.getExchangeRate(origin.getCurrency(), destiny.getCurrency());
		
		transfer.setExchangeRate(exchangeRate);
		
		this.transferDao.save(transfer);
		
		origin = this.accountService.find(Account.class, origin.getId());
		destiny = this.accountService.find(Account.class, destiny.getId());
		
		if (origin.getId().equals(destiny.getId())) {
			throw new Exception("You can not transfer amount to the same account!");
		}
		
		this.accountService.debit(origin, amount);
		this.accountService.merge(origin);
		
		this.accountService.credit(destiny, amount.multiply(exchangeRate));
		this.accountService.merge(destiny);
		
		return transfer;
	}
	
	private void validate(Transfer transfer) throws Exception {
		if (transfer.getOriginAccount() == null || transfer.getDestinationAccount() == null) {
			throw new Exception("Origin and Destiny accounts are required fields!");
		}
		
		if (transfer.getOriginTransferAmount() == null || transfer.getOriginTransferAmount().compareTo(BigDecimal.ZERO) <= EQUAL_VALUE) {
			throw new Exception("Amount is a required field and needs to be higher than zero!");
		}
	}

}
