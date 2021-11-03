package com.saka.usa;

import javax.websocket.MessageHandler;

import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.integration.AckMode;
import com.google.cloud.spring.pubsub.integration.inbound.PubSubInboundChannelAdapter;
import com.google.cloud.spring.pubsub.integration.outbound.PubSubMessageHandler;
import com.google.cloud.spring.pubsub.support.BasicAcknowledgeablePubsubMessage;
import com.google.cloud.spring.pubsub.support.GcpPubSubHeaders;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.integration.annotation.ServiceActivator;
//import org.springframework.integration.channel.PublishSubscribeChannel;
//import org.springframework.integration.support.MessageBuilder;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.MessageChannel;
//import org.springframework.messaging.handler.annotation.Header;
//import reactor.core.publisher.Flux;
//import reactor.core.scheduler.Schedulers;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.util.concurrent.ListenableFutureCallback;


@SpringBootApplication
public class SpringBootGCPApp {

	private static final Log LOGGER = LogFactory.getLog(SpringBootGCPApp.class);
	private static final Random rand = new Random(2020);

	public static void main(String args[]) {
		SpringApplication.run(SpringBootGCPApp.class, args);
	}

	
//	@Bean
//	public MessageChannel inputMessageChannel() {
//		return new PublishSubscribeChannel();
//	}
//
//	@Bean
//	public PubSubInboundChannelAdapter inboundChannelAdapter(
//			@Qualifier("inputMessageChannel") MessageChannel messageChannel, PubSubTemplate pubSubTemplate) {
//		PubSubInboundChannelAdapter adapter = new PubSubInboundChannelAdapter(pubSubTemplate, "sub-one");
//		adapter.setOutputChannel(messageChannel);
//		adapter.setAckMode(AckMode.MANUAL);
//		adapter.setPayloadType(String.class);
//		return adapter;
//	}
//
//	// Define what happens to the messages arriving in the message channel.
//	@ServiceActivator(inputChannel = "inputMessageChannel")
//	public void messageReceiver(String payload,
//			@Header(GcpPubSubHeaders.ORIGINAL_MESSAGE) BasicAcknowledgeablePubsubMessage message) {
//	    LOGGER.info("Message arrived via an inbound channel adapter from sub-one! Payload: " + payload);
//		message.ack();
//	}
//	
//	@Bean
//	@ServiceActivator(inputChannel = "inputMessageChannel")
//	public org.springframework.messaging.MessageHandler messageSender(PubSubTemplate pubsubTemplate) {
//		PubSubMessageHandler adapter = new PubSubMessageHandler(pubsubTemplate, "topic-two");
//
//		adapter.setPublishCallback(new ListenableFutureCallback<String>() {
//			@Override
//			public void onFailure(Throwable throwable) {
////	            LOGGER.info("There was an error sending the message.");
//			}
//
//			@Override
//			public void onSuccess(String result) {
////	            LOGGER.info("Message was sent via the outbound channel adapter to topic-two!");
//			}
//		});
//		return adapter;
//	}
//	
//	@Bean
//	public Consumer<Message<String>> receiveMessageFromTopicTwo() {
//		return message -> {
//	      LOGGER.info("Message arrived via an input binder from topic-two! Payload: " + message.getPayload());
//		};
//	}
//	
//	@Bean
//	public Supplier<Flux<Message<String>>> sendMessageToTopicOne() {
//		return () -> Flux.<Message<String>>generate(sink -> {
//			try {
//				Thread.sleep(10000);
//			} catch (InterruptedException e) {
//				// stop sleep earlier.
//			}
//
//			Message<String> message = MessageBuilder.withPayload("message-" + rand.nextInt(1000)).build();
//	              LOGGER.info("Sending a message via the output binder to topic-one! Payload: "+ message.getPayload());
//			sink.next(message);
//		}).subscribeOn(Schedulers.elastic());
//	}

}
