package io.javabrains.springbootstarter.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ContactInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1454206990597755745L;

	private String emailId;

	private String phoneNumber;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "ContactInfo [emailId=" + emailId + ", phoneNumber="
				+ phoneNumber + "]";
	}
	

}
