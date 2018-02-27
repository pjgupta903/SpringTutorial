package io.javabrains.springbootstarter.repository;

import java.util.List;

import io.javabrains.springbootstarter.model.ContactInfo;
import io.javabrains.springbootstarter.model.Person;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person,ContactInfo > {

	List<Person> findByContactinfoEmailId(String email);
	
	List<Person> findByContactinfo(ContactInfo contInf);

}
