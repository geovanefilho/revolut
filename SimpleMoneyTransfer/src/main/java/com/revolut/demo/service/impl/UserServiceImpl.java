/**
 * 
 */
package com.revolut.demo.service.impl;

import com.revolut.demo.dao.AccountDao;
import com.revolut.demo.dao.UserDao;
import com.revolut.demo.dao.impl.AccountDaoImpl;
import com.revolut.demo.dao.impl.UserDaoImpl;
import com.revolut.demo.model.Account;
import com.revolut.demo.model.User;
import com.revolut.demo.service.UserService;

/**
 * @author geovanefilho
 *
 */
public class UserServiceImpl extends DemoServiceImpl<User> implements UserService {

	private UserDao userDao;
	private AccountDao accountDao;
	
	public UserServiceImpl(UserDao userDao) {
		super(userDao);
		if (userDao == null) {
			userDao = new UserDaoImpl();
			this.userDao = userDao;
			this.accountDao = new AccountDaoImpl();
		}
	}
	
	@Override
	public User save(User user) throws Exception {
		validate(user);
		
		User userOld = this.userDao.findByUserName(user.getUsername());
		if (userOld != null) {
			throw new Exception("There is already an User with the username: " + user.getUsername());
		}
		
		Account acc = this.accountDao.findByNumer(user.getAccount().getNumber());
		if (acc != null) {
			throw new Exception("There is already an Account with the number: " + acc.getNumber());
		}
		
		return super.save(user);
	}

	@Override
	public User findByUserName(String username) {
		return this.userDao.findByUserName(username);
	}
	
	private void validate(User user) throws Exception {
		String reqFields = "";
		if (user.getName() == null || user.getUsername() == null) {
			reqFields += "userName";
		}
		
		if (user.getEmail() == null) {
			if (!reqFields.isEmpty()) {
				reqFields += ", ";
			}
			reqFields += "email";
		}
		
		Account acc = user.getAccount();
		
		if (acc.getNumber() == null) {
			if (!reqFields.isEmpty()) {
				reqFields += ", ";
			}
			reqFields += "accNumber";
		}
		
		if (acc.getCurrency() == null) {
			if (!reqFields.isEmpty()) {
				reqFields += ", ";
			}
			reqFields += "accCurrency";
		}
		
		if (acc.getBalance() == null) {
			if (!reqFields.isEmpty()) {
				reqFields += ", ";
			}
			reqFields += "accBalance";
		}
		
		if (!reqFields.isEmpty()) {
			throw new Exception("The following fiels are required: " + reqFields);
		}
	}

}
