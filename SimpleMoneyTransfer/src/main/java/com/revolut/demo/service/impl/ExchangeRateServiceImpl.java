/**
 * 
 */
package com.revolut.demo.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.revolut.demo.model.Currency;
import com.revolut.demo.service.ExchangeRateService;

/**
 * 
 * Service responsible for get the Exchange Rate from currencies.
 * Its just a mock for the purpose of the demonstration
 * 
 * @author geovanefilho
 *
 */
public class ExchangeRateServiceImpl implements ExchangeRateService {
	
	//Rates from the Currencies of the Enum
    private Map<Currency, Map<Currency, BigDecimal>> rates;
	
	public ExchangeRateServiceImpl() {
		this.rates = new HashMap<Currency, Map<Currency, BigDecimal>>();
		this.rates.put(Currency.BRL, getBRRates());
		this.rates.put(Currency.EUR, getEURates());
		this.rates.put(Currency.GBP, getGBRates());
		this.rates.put(Currency.USD, getUSRates());
	}
	
	/**
	 * Exchange rates when BRL is the origin
	 * 
	 * @return Map<Currency, BigDecimal> with the destiny rates
	 */
	private Map<Currency, BigDecimal> getBRRates() {
		Map<Currency, BigDecimal> rates = new HashMap<Currency, BigDecimal>();
		rates.put(Currency.BRL, BigDecimal.ONE);
		rates.put(Currency.EUR, new BigDecimal(0.2294));
		rates.put(Currency.GBP, new BigDecimal(0.2014));
		rates.put(Currency.USD, new BigDecimal(0.2695));
		return rates;
	}
	
	/**
	 * Exchange rates when USD is the origin
	 * 
	 * @return Map<Currency, BigDecimal> with the destiny rates
	 */
	private Map<Currency, BigDecimal> getUSRates() {
		Map<Currency, BigDecimal> rates = new HashMap<Currency, BigDecimal>();
		rates.put(Currency.USD, BigDecimal.ONE);
		rates.put(Currency.EUR, new BigDecimal(0.8498));
		rates.put(Currency.GBP, new BigDecimal(0.7460));
		rates.put(Currency.BRL, new BigDecimal(3.7099));
		return rates;
	}
	
	/**
	 * Exchange rates when Euro is the origin
	 * 
	 * @return Map<Currency, BigDecimal> with the destiny rates
	 */
	private Map<Currency, BigDecimal> getEURates() {
		Map<Currency, BigDecimal> rates = new HashMap<Currency, BigDecimal>();
		rates.put(Currency.EUR, BigDecimal.ONE);
		rates.put(Currency.USD, new BigDecimal(1.1767));
		rates.put(Currency.GBP, new BigDecimal(0.8781));
		rates.put(Currency.BRL, new BigDecimal(4.3590));
		return rates;
	}
	
	/**
	 * Exchange rates when GBP is the origin
	 * 
	 * @return Map<Currency, BigDecimal> with the destiny rates
	 */
	private Map<Currency, BigDecimal> getGBRates() {
		Map<Currency, BigDecimal> rates = new HashMap<Currency, BigDecimal>();
		rates.put(Currency.GBP, BigDecimal.ONE);
		rates.put(Currency.USD, new BigDecimal(1.3404));
		rates.put(Currency.EUR, new BigDecimal(1.1388));
		rates.put(Currency.BRL, new BigDecimal(4.9642));
		return rates;
	}
	
	/**
	 * 
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public BigDecimal getExchangeRate(String originCode, String destinyCode) throws Exception {
		return this.getExchangeRate(Currency.getByCode(originCode), Currency.getByCode(destinyCode));
	}
	
	/**
	 * 
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public BigDecimal getExchangeRate(Currency origin, Currency destiny) throws Exception {
		if (origin == null || destiny == null) {
			throw new Exception("Origin and destiny currencies are required to do the exchange rate!");
		}
		
		return rates.get(origin).get(destiny);
	}

}
