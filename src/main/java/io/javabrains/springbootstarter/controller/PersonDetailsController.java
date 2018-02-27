package io.javabrains.springbootstarter.controller;

import java.util.List;

import io.javabrains.springbootstarter.model.Person;
import io.javabrains.springbootstarter.service.PersonDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonDetailsController {
	
	@Autowired
	private PersonDetailService firstService;
	
	@RequestMapping(value="/persons")
	public List<Person> getPerson(){
		return firstService.getAllPerson();
	}
	
	@RequestMapping(value="/person/{email:.+}", method=RequestMethod.GET,produces={"application/json","application/xml"})
	@ResponseBody
	public List<Person> getPersonByEmail(@PathVariable(value="email") String emailId){
		return firstService.getPersonByEmail(emailId);
	}
	
	@RequestMapping(value="/person/{email:.+}/{phoneNumber}", method=RequestMethod.GET)
	@ResponseBody
	public List<Person> getPersonByEmailAndPhoneNumber(@PathVariable(value="email") String emailId,@PathVariable String phoneNumber){
		return firstService.getPersonByEmailAndPhoneNumber(emailId,phoneNumber);
	}
	
	@RequestMapping(value="/addPerson", method=RequestMethod.POST)
	@ResponseBody
	public Person addPerson(@RequestBody Person person){
		return firstService.addPerson(person);
	}
	
	@RequestMapping(value="/person", method=RequestMethod.GET)
	@ResponseBody
	public List<Person> getPerson(@RequestParam(value="email") String emailId){
		return firstService.getPersonByEmail(emailId);
	}
	
}
