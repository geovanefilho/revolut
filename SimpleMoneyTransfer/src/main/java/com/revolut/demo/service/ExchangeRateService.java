/**
 * 
 */
package com.revolut.demo.service;

import java.math.BigDecimal;

import com.revolut.demo.model.Currency;

/**
 * 
 * A mock service to calculate the Exchange Rate between currencies
 * 
 * @author geovanefilho
 *
 */
public interface ExchangeRateService {

	/**
	 * Get a exchange rate by two Currencies
	 * 
	 * @param originCode
	 * @param destinyCode
	 * @return
	 * @throws Exception
	 */
	public BigDecimal getExchangeRate(Currency originCode, Currency destinyCode) throws Exception;

	/**
	 * Get a exchange rate by two Currencies codes
	 * 
	 * @param originCode
	 * @param destinyCode
	 * @return
	 * @throws Exception
	 */
	public BigDecimal getExchangeRate(String originCode, String destinyCode) throws Exception;
	
}
