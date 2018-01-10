package edjdc.demo.springevents.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edjdc.demo.springevents.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
