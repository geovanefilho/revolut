package com.revolut.demo.dao;

import com.revolut.demo.model.Account;

public interface AccountDao extends AbstractDao<Account> {

	Account findByNumer(String number);

}
