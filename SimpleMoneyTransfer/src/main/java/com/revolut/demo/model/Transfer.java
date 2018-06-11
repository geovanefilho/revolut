/**
 * 
 */
package com.revolut.demo.model;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * Responsible class for store the data from the transference between accounts
 * 
 * @author geovanefilho
 *
 */
@Entity
public class Transfer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "oriAccount_id")
	private Account originAccount;
	
	@ManyToOne
	@JoinColumn(name = "destAccount_id")
	private Account destinationAccount;
	
	@Column(name = "oriTransfAmount", precision = 14, scale = 2)
	private BigDecimal originTransferAmount;
	
	@Column(name = "exchangeRate", precision = 14, scale = 2)
	private BigDecimal exchangeRate = BigDecimal.ONE;
	
	@Column(name = "transfer_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar transferDate;

	protected Transfer() {
		super();
	}

	public Transfer(Account originAccount, Account destinationAccount, BigDecimal originTransferAmount) {
		super();
		this.originAccount = originAccount;
		this.destinationAccount = destinationAccount;
		this.originTransferAmount = originTransferAmount;
		this.transferDate = Calendar.getInstance();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Account getOriginAccount() {
		return originAccount;
	}

	public void setOriginAccount(Account originAccount) {
		this.originAccount = originAccount;
	}

	public Account getDestinationAccount() {
		return destinationAccount;
	}

	public void setDestinationAccount(Account destinationAccount) {
		this.destinationAccount = destinationAccount;
	}

	public BigDecimal getOriginTransferAmount() {
		return originTransferAmount;
	}
	
	public BigDecimal getDestinationTransferAmount() {
		return originTransferAmount.multiply(exchangeRate);
	}

	public void setOriginTransferAmount(BigDecimal originTransferAmount) {
		this.originTransferAmount = originTransferAmount;
	}

	public BigDecimal getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(BigDecimal exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public Calendar getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(Calendar transferDate) {
		this.transferDate = transferDate;
	}
}
