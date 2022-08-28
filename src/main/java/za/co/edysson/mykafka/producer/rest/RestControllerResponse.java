package za.co.edysson.mykafka.producer.rest;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RestControllerResponse<T> implements Serializable {
	private static final long serialVersionUID = -2024582609610340253L;
	
	private String responseCode;
	private String responseMessage;
	private T response;
}
