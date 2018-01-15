package com.lmig.gfc.charicycle.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Charity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = true)
	private String longInId;

	@Column(nullable = true)
	private String password;

	@Column(length = 75, nullable = false)
	private String organizationName;
	
	@Column(length = 30, nullable = false)
	private String contactFirstName;
	
	@Column(length = 30, nullable = false)
	private String contactLastName;

	@Column(length = 75, nullable = true)
	private String taxId;

	@Column(nullable = true)
	private String addressLine;
	
	@Column(nullable = true)
	private String city;
	
	@Column(nullable = true)
	private String state;
	
	@Column(nullable = true)
	private String zip;

	@Column(nullable = false)
	private String emailAddress;
	
	@Column(length = 75)
	private String phoneNumber;

	@OneToMany(mappedBy = "charity") // One charity has many Needed Items
	private List<Item> neededItems;

	public Charity() {
	};


	public Charity(String organizationName, String contactFirstName,
			String contactLastName, String taxId, String addressLine, String city, String state, String zip,
			String emailAddress, String phoneNumber) {
		
		this.organizationName = organizationName;
		this.contactFirstName = contactFirstName;
		this.contactLastName = contactLastName;
		this.taxId = taxId;
		this.addressLine = addressLine;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLongInId() {
		return longInId;
	}

	public void setLongInId(String longInId) {
		this.longInId = longInId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}


	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public List<Item> getNeededItems() {
		return neededItems;
	}

	public void setNeededItems(List<Item> neededItems) {
		this.neededItems = neededItems;
	}


	public String getContactFirstName() {
		return contactFirstName;
	}


	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}


	public String getContactLastName() {
		return contactLastName;
	}


	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}


	public String getAddressLine() {
		return addressLine;
	}


	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
