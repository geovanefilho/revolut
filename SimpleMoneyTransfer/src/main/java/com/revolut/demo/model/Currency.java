/**
 * 
 */
package com.revolut.demo.model;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * Enum whit some Currencies
 * 
 * @author geovanefilho
 *
 */
public enum Currency {

	BRL(986, 2),
    EUR(978, 2),
    GBP(826, 2),
    USD(840, 2);

    private final int code;
    private final int minorUnit;
    
    Currency(int code, int minorUnit) {
        this.code = code;
        this.minorUnit = minorUnit;
    }
    
    public final static Map<String, Currency> CURRENCIES = Stream.of(values())
            .collect(Collectors.toMap(Currency::code, e -> e));

    public String code() {
        return name();
    }

    public int numericCode() {
        return code;
    }

    public int minorUnit() {
        return minorUnit;
    }

    public static Currency getByCode(String code) {
        Currency currency = CURRENCIES.get(code);
        if (currency == null) {
            throw new IllegalArgumentException("Currency for code '" + code + "' unavailable!");
        }
        return currency;
    }
    
}
