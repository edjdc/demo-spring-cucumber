package edjdc.demo.springevents.service;

import java.util.List;

import edjdc.demo.springevents.dto.CreatedPersonDTO;
import edjdc.demo.springevents.dto.PersonDTO;

public interface PersonService {

	Long create(CreatedPersonDTO dto);
	
	PersonDTO findOne(Long id);
	
	List<PersonDTO> findAll();
	
}
