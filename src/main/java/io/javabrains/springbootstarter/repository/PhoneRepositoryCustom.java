package io.javabrains.springbootstarter.repository;

import io.javabrains.springbootstarter.model.Phone;

import java.util.List;

public interface PhoneRepositoryCustom {
	
	public List<Phone> getDistinctPhonesByPersonEmail(String emailId);
	
	public List<Phone> getAllPhonesByNamedQuery();

}
