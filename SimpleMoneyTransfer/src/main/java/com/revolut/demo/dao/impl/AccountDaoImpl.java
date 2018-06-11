/**
 * 
 */
package com.revolut.demo.dao.impl;

import java.util.List;

import com.revolut.demo.dao.AccountDao;
import com.revolut.demo.model.Account;

/**
 * @author geovanefilho
 *
 */
public class AccountDaoImpl extends DemoDaoImpl<Account> implements AccountDao {

	private static final int FIRST_ELEMENT = 0;

	@Override
	public Account findByNumer(String number) {
		List<Account> accounts = EntityManagerHelper.getEntityManager().createQuery("Select acc from " + Account.class.getSimpleName() + " acc WHERE acc.number = '" + number + "'", Account.class).getResultList();
		if (accounts.isEmpty()) {
			return null;
		} else {
			return accounts.get(FIRST_ELEMENT);
		}
	}

}
