package io.javabrains.springbootstarter.model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person {
	
	// multiple columns as primary key
	@EmbeddedId
	@AttributeOverrides({
	@AttributeOverride(name="emailId", column=@Column(name="email_id")),
	@AttributeOverride(name="phoneNumber", column=@Column(name="phone_number"))
	 })
	private ContactInfo contactinfo;
	
	public ContactInfo getContactinfo() {
		return contactinfo;
	}

	public void setContactinfo(ContactInfo contactinfo) {
		this.contactinfo = contactinfo;
	}

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="age")
	private String age;
	
	/*@OneToMany
	@JoinTable(name="person_phone", joinColumns=@JoinColumn(name="email_id"),inverseJoinColumns=@JoinColumn(name="phone_id"))
	private List<Phone> phones;*/
	

	public Person() {
	}
	
	public Person(String emailId, String firstName, String lastName,
			String age, List<Phone> phones) {
		super();
		//this.emailId = emailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	/*public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}*/

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}





}
