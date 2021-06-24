package com.example.camelpart2;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JsonTransformer {
	
	public CurrencyConverter setConversion( CurrencyConverter CurrencyExchange ) {
		
		 CurrencyExchange.setConversionMultiple(new BigDecimal(1000000));		 
		 return CurrencyExchange;
		
	}

}
