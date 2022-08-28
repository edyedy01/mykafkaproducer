package za.co.edysson.mykafka.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MyKafkaService {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String topicName, String messageContent) {
		log.debug("Entering sendMessage:  topicName={}, messageContent={}", topicName, messageContent);
		
		/**
		 * FROM THE DOCS
		 * 
		 * The send API returns a ListenableFuture object. If we want to block the sending thread and get the result about the sent message, we can call the get API of the ListenableFuture object. 
		 * The thread will wait for the result, but it will slow down the producer.
		 *
		 * Kafka is a fast stream processing platform. Therefore, it's better to handle the results asynchronously so that the subsequent messages do not wait for the result of the previous message.
		 */
		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, messageContent);
				
	    future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

	        @Override
	        public void onSuccess(SendResult<String, String> result) {
	            log.debug("Sent message=[" + messageContent + 
	              "] with offset=[" + result.getRecordMetadata().offset() + "]");
	        }
	        @Override
	        public void onFailure(Throwable ex) {
	        	log.debug("Unable to send message=[" 
	              + messageContent + "] due to : " + ex.getMessage());
	        }
	    });
	}
}
