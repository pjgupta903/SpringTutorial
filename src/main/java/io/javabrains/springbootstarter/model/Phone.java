package io.javabrains.springbootstarter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="phone")
@NamedQuery(name="Phone.findAll",query="select p from Phone p")
public class Phone {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="phone_id")
	private Long id;
	
	@Column(name="phone_name")
	private String phoneName;
	
	@Column(name="operating_system")
	private String operatingSystem;

	@ManyToOne
	private Person person;
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhoneName() {
		return phoneName;
	}

	public void setPhoneName(String phoneName) {
		this.phoneName = phoneName;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	@Override
	public String toString() {
		return "Phone [id=" + id + ", phoneName=" + phoneName
				+ ", operatingSystem=" + operatingSystem + ", person=" + person
				+ "]";
	}



}
