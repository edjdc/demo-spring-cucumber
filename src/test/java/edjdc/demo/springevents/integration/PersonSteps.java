package edjdc.demo.springevents.integration;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import edjdc.demo.springevents.dto.CreatedPersonDTO;
import edjdc.demo.springevents.dto.PersonDTO;
import edjdc.demo.springevents.service.PersonService;

public class PersonSteps extends CucumberRoot {

	private ResponseEntity<PersonDTO> response;
	private Long idPerson;
	
	@Autowired
	private PersonService personService;

	@Dado("^que existe um cliente cadastrado com o primeiro nome \"([^\"]*)\", segundo nome \"([^\"]*)\" e idade de (\\d+)$")
	public void que_existe_um_cliente_cadastrado_com_o_primeiro_nome_segundo_nome_e_idade_de(String firstName, String lastName, int age) throws Throwable {
		CreatedPersonDTO dto = new CreatedPersonDTO();
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setAge(age);
		idPerson = personService.create(dto);
	}

	@Quando("^o cliente consulta pelo id$")
	public void o_cliente_consulta_pelo_id() throws Throwable {
		response = template.getForEntity("/person/" + idPerson, PersonDTO.class);
	}

	@Entao("^o cliente recebe o status code (\\d+)$")
	public void o_cliente_recebe_o_status_code(int statusCode) throws Throwable {
		HttpStatus currentStatusCode = response.getStatusCode();
		assertThat("status code is incorrect : " + response.getBody(), currentStatusCode.value(), is(statusCode));
	}

	@Entao("^o cliente recebe o primeiro \"([^\"]*)\", segundo nome \"([^\"]*)\" e idade de (\\d+)$")
	public void o_cliente_recebe_o_primeiro_segundo_nome_e_idade_de(String firstName, String lastName, int age) throws Throwable {
		PersonDTO dto = response.getBody();
		assertThat(dto.getFirstName(), equalTo(firstName));
		assertThat(dto.getLastName(), equalTo(lastName));
		assertThat(dto.getAge(), equalTo(age));
	}
	

}
