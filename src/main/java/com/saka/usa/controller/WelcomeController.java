package com.saka.usa.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.integration.inbound.PubSubInboundChannelAdapter;
import com.google.cloud.spring.pubsub.support.BasicAcknowledgeablePubsubMessage;
import com.google.cloud.spring.pubsub.support.GcpPubSubHeaders;
import com.saka.usa.schedular.WelcomeSchedular;

@RestController
public class WelcomeController extends WelcomeSchedular{
	
//	String message;
	
	@GetMapping("get-message")
	public String geMessage() {
		
//		WelcomeSchedular wecomeSc = new WelcomeSchedular();
		
		return "Message From GCP: "+ message;
	}
	
}
