/**
 * 
 */
package com.revolut.demo.service;

import java.math.BigDecimal;

import com.revolut.demo.model.Currency;

/**
 * @author geovanefilho
 *
 */
public interface ExchangeRateService {

	public BigDecimal getExchangeRate(Currency originCode, Currency destinyCode) throws Exception;

	public BigDecimal getExchangeRate(String originCode, String destinyCode) throws Exception;
	
}
