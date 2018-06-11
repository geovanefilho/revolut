/**
 * 
 */
package com.revolut.demo.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * 
 * Responsible class for store the data from the account of a user
 * 
 * @author geovanefilho
 *
 */
@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 255, name = "number", nullable = false, unique = true)
	private String number;
	
	@Enumerated(EnumType.STRING)
	private Currency currency;
	
	@Column(precision = 14, scale = 2, name = "balance", nullable = false)
	private BigDecimal balance = BigDecimal.ZERO;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "user_id")
	private User user;

	protected Account() {
		super();
	}

	public Account(String number, BigDecimal balance, String currencyCode) {
		super();
		this.number = number;
		this.balance = balance;
		this.currency = Currency.getByCode(currencyCode);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void debit(BigDecimal amount) {
		if (this.balance != null) {
			this.balance = this.balance.subtract(amount);
		} else {
			this.balance = BigDecimal.ZERO.subtract(amount);
		}
	}

	public void credit(BigDecimal amount) {
		if (this.balance != null) {
			this.balance = this.balance.add(amount);
		} else {
			this.balance = BigDecimal.ZERO.add(amount);
		}
	}

}
