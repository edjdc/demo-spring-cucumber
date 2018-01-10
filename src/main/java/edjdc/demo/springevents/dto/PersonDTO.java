package edjdc.demo.springevents.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class PersonDTO implements Serializable {

	private static final long serialVersionUID = -2262003918981548228L;

	private Long id;
	private String firstName;
	private String lastName;
	private Integer age;

}
