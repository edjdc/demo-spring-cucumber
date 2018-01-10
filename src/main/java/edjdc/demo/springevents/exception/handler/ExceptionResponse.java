package edjdc.demo.springevents.exception.handler;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = -4685608519418586575L;

	private String errorCode;
	private String errorMessage;
	private List<String> errors;

}
