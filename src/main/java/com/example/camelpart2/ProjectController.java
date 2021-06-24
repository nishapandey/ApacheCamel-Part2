package com.example.camelpart2;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {
	@Autowired
	CurrencyConverter ch;
	@GetMapping("/getConversions")
	public CurrencyConverter getConversions() {
		ch.setId(1L);
		ch.setTo("INR");
		ch.setFrom("USD");
		ch.setConversionMultiple(new BigDecimal(1000000));		 
		 return ch;
		
	}

}
