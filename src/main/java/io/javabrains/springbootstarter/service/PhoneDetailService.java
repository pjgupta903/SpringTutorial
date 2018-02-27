package io.javabrains.springbootstarter.service;

import io.javabrains.springbootstarter.model.ContactInfo;
import io.javabrains.springbootstarter.model.Person;
import io.javabrains.springbootstarter.model.Phone;
import io.javabrains.springbootstarter.repository.PersonRepository;
import io.javabrains.springbootstarter.repository.PhoneCrudRepository;
import io.javabrains.springbootstarter.repository.PhoneRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneDetailService {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private  PhoneCrudRepository phoneCrudRepo ;
	
	@Autowired
	private PhoneRepository phoneRepository;
	
	@Autowired
	private PersonDetailService personDetailService;

	public List<Phone> getPhonesByPersonFirstName(String firstName){
		return phoneCrudRepo.findByPersonFirstName(firstName);
	}

	public List<Phone> getPhonesByPersonEmailId(String emailId){
		return phoneCrudRepo.findByPersonContactinfoEmailId(emailId);
		//return phoneCrudRepo.findByPersonEmailId(emailId);	
	}
	
	public Phone getPhoneByName(String phoneName){
		return null;
		//return (Phone) phoneCrudRepo.findByPhoneName(phoneName);
	}
	
	
	public Phone addPhoneByEmail(String emailId,String phonenumber, Phone phone) {
		ContactInfo contactInfo = new ContactInfo();
		contactInfo.setPhoneNumber(phonenumber);
		contactInfo.setEmailId(emailId);
		boolean isExist = personRepository.exists(contactInfo);
		if(isExist){
			return null;
		}else{
			Person person = new Person();
			person.setContactinfo(contactInfo);
			Person savedPerson = personRepository.save(person);
			phone.setPerson(savedPerson);
			return phoneCrudRepo.save(phone);
		}
	}


	public List<Phone> findByPhoneNameAndOperatingSystem(String phoneName,String operatingSystem) {
		return null;
		//return phoneCrudRepo.findByPhoneNameAndOperatingSystem(phoneName,operatingSystem);
	}

	//custom method
	public List<Phone> getDistinctPhonesBasedOnOPeratingSystemByPersonEmail(String emailId) {
		return phoneRepository.getDistinctPhonesByPersonEmail(emailId);
	}

	public List<Phone> getData() {
		return phoneRepository.getAllPhonesByNamedQuery();
	}

	public List<Phone> getPhonesByEmailIdAndPhoneNumber(String emailId,
			String phoneNumber) {
		ContactInfo contactInfo = new ContactInfo();
		contactInfo.setPhoneNumber(phoneNumber);
		contactInfo.setEmailId(emailId);
		return phoneCrudRepo.findByPersonContactinfo(contactInfo);
	}
	
	

}
