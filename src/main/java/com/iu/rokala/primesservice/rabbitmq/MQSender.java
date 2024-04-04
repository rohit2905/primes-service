package com.iu.rokala.primesservice.rabbitmq;

import java.text.MessageFormat;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class MQSender {

	private final Queue queue;
	
	private final RabbitTemplate rabbitTemplate;

	public MQSender(Queue queue, RabbitTemplate rabbitTemplate) {
		super();
		this.queue = queue;
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public void sendMessage(long n, boolean isPrime) {
		String message = MessageFormat.format("n: {0}, isPrime: {1}", n, isPrime);
		rabbitTemplate.convertAndSend("primes", message);
	}
}
