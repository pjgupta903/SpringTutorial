package io.javabrains.springbootstarter.service;

import io.javabrains.springbootstarter.model.ContactInfo;
import io.javabrains.springbootstarter.model.Person;
import io.javabrains.springbootstarter.repository.PersonRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonDetailService {
	
	@Autowired
	private  PersonRepository personRepository ;
	
	public String simpleStringMethod(){
		return "Spring boot application";
	}
	
	
	public List<Person> getAllPerson(){
		return (List<Person>) personRepository.findAll();
	}


	public List<Person> getPersonByEmail(String email) {
		return personRepository.findByContactinfoEmailId(email);
	}


	public Person addPerson(Person person) {
		return personRepository.save(person);
	}

	public List<Person> getPersonByEmailAndPhoneNumber(String emailId,
			String phoneNumber) {
		ContactInfo contInf = new ContactInfo();
		contInf.setPhoneNumber(phoneNumber);
		contInf.setEmailId(emailId);
		return personRepository.findByContactinfo(contInf);
	}
	
	
}
