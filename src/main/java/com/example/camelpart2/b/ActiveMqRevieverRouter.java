package com.example.camelpart2.b;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.camelpart2.CurrencyConverter;
import com.example.camelpart2.JsonTransformer;

@Component
public class ActiveMqRevieverRouter extends RouteBuilder{
	@Autowired
	JsonTransformer JsonTransformer;
	
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		//creating a sender route which sends constant message  to activemq queues every10seconds	
		Object mq = from("activemq:myQueue")
				.unmarshal().json(JsonLibrary.Jackson,CurrencyConverter.class)
				.bean(JsonTransformer)
				.log("JSON transformer ${body}")
				.to("log:Reciever body ${body}")
				;
		
	}

}
