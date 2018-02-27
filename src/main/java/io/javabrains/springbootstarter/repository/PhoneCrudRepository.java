package io.javabrains.springbootstarter.repository;

import java.util.List;

import io.javabrains.springbootstarter.model.ContactInfo;
import io.javabrains.springbootstarter.model.Phone;

import org.springframework.data.repository.CrudRepository;

public interface PhoneCrudRepository extends CrudRepository<Phone, Long> {
	
	public List<Phone> findByPersonContactinfoEmailId(String emailId);
	
	public List<Phone> findByPersonContactinfo(ContactInfo contactInfo);
	
	public List<Phone> findByPersonFirstName(String firstName);
	
	/*//get records based on multiple conditions
	public List<Phone> findByPhoneNameAndOperatingSystem(String phone,String operatingSystem);
	
	
	
	public Phone findByPhoneName(String phoneName);
	
	//get distinct records
	public List<Phone> findDistinctPhoneByOperatingSystem(String op);*/
	
}
