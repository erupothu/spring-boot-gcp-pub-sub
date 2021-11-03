package com.saka.usa.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;

import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.integration.inbound.PubSubInboundChannelAdapter;

@Configuration
public class GCPConfig {
	
	@Bean
	public PubSubInboundChannelAdapter messageAdapterSubOne(@Qualifier("inputChannel") MessageChannel inputChannel, PubSubTemplate template) {
		
		PubSubInboundChannelAdapter adapter = new PubSubInboundChannelAdapter(template, "sub-one");
		adapter.setOutputChannel(inputChannel);
		return adapter;
	}
	
//	@Bean
//	public PubSubInboundChannelAdapter messageAdapterSubThree(@Qualifier("inputChannel") MessageChannel inputChannel, PubSubTemplate template) {
//		
//		PubSubInboundChannelAdapter adapter = new PubSubInboundChannelAdapter(template, "sub-three");
//		adapter.setOutputChannel(inputChannel);
//		return adapter;
//	}
	
	@Bean
	MessageChannel inputChannel() {
		return new DirectChannel();
	}

}
