package com.example.camelpart2.rest;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.camelpart2.CurrencyConverter;
import com.example.camelpart2.JsonTransformer;

@Component
public class RestRouter extends RouteBuilder{
	@Autowired
	JsonTransformer JsonTransformer;
	
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		//creating a sender route which sends constant message  to activemq queues every10seconds	
		restConfiguration().host("localhost").port(8000);
		Object mq = 
				from("timer:rest-api?period=10000")
				.log("${body}")
				.to("rest:get:/getConversions")
				.log("${body}")
				
				/*
				from("rest:get:/getConversions")
				.log("${body}")
				.to("activemq:RestQueue")
				.log("${body}")
				
				*/
				;
		
	}

}
