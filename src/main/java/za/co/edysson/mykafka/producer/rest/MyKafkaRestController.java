package za.co.edysson.mykafka.producer.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import za.co.edysson.mykafka.producer.service.MyKafkaService;

@Slf4j
@RestController
@RequestMapping("/")
public class MyKafkaRestController {
	
	@Autowired
	private MyKafkaService myKafkaService; 

	@PostMapping("/api/v1/message/{customMessage}")
	public RestControllerResponse<String> executePost(@PathVariable @NonNull String customMessage) {
		log.debug("Entering executePost:  customMessage={}", customMessage);
		
		this.myKafkaService.sendMessage("test", customMessage);
		
		RestControllerResponse<String> restControllerResponse = new RestControllerResponse<String>();
		restControllerResponse.setResponseCode(RestControllerResponseCode.OK.name());
		restControllerResponse.setResponseMessage("Message sent.");
		
		return restControllerResponse;
	}
}
