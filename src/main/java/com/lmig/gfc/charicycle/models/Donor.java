package com.lmig.gfc.charicycle.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Donor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String companyName;

	@Column(length = 75, nullable = false)
	private String contactFirstName;

	@Column(length = 75, nullable = false)
	private String contactLastName;
	private String addressLine;
	private String city;
	private String state;
	private String zip;
	private String phoneNumber;

	@Column(nullable = false)
	private String email;

	@OneToMany(mappedBy = "donor") // One donor has many Donated Items
	private List<DonatedItem> donatedItems;

	public Donor() {
	}

	public Donor(String companyName, String contactFirstName, String contactLastName, String addressLine, String city,
			String state, String zip, String phoneNumber, String email) {
		this.companyName = companyName;
		this.contactFirstName = contactFirstName;
		this.contactLastName = contactLastName;
		this.addressLine = addressLine;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<DonatedItem> getDonatedItems() {
		return donatedItems;
	}

	public void setDonatedItems(List<DonatedItem> donatedItems) {
		this.donatedItems = donatedItems;
	}

}
