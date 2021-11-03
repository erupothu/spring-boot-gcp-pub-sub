package com.saka.usa.schedular;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Header;

import com.google.cloud.spring.pubsub.support.BasicAcknowledgeablePubsubMessage;
import com.google.cloud.spring.pubsub.support.GcpPubSubHeaders;

public class WelcomeSchedular {
	
	public String message;
	
	@ServiceActivator(inputChannel = "inputChannel")
	public void receiveMessage(String payload, @Header(GcpPubSubHeaders.ORIGINAL_MESSAGE) BasicAcknowledgeablePubsubMessage message) {
		this.message = payload;
	}

}
