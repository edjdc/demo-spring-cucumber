package edjdc.demo.springevents.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edjdc.demo.springevents.dto.CreatedPersonDTO;
import edjdc.demo.springevents.dto.PersonDTO;
import edjdc.demo.springevents.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody @Valid CreatedPersonDTO dto) {
		Long id = personService.create(dto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PersonDTO findOne(@PathVariable Long id) {
		return personService.findOne(id);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<PersonDTO> findAll() {
		return personService.findAll();
	}
}
