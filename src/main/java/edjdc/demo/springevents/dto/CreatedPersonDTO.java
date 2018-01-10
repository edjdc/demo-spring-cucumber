package edjdc.demo.springevents.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class CreatedPersonDTO implements Serializable {

	private static final long serialVersionUID = 8289001321908587069L;

	@NotBlank
	@Length(max = 255)
	private String firstName;
	@NotBlank
	@Length(max = 255)
	private String lastName;
	@NotNull
	@Range(min = 0, max = 150)
	private Integer age;

}
