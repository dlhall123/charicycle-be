package com.lmig.gfc.charicycle.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Charity extends Users {

	@Column(length = 75, nullable = true)
	private String taxId;

	@OneToMany(mappedBy = "charity") // One charity has many Needed Items
	private List<Item> neededItems;

	public Charity() {
	};

	public Charity(String organizationName, String contactFirstName, String contactLastName, String taxId,
			String addressLine, String city, String state, String zip, String emailAddress, String phoneNumber,
			String userName, String password) {

		super.setCompanyName(organizationName);
		super.setContactFirstName(contactFirstName);
		super.setContactLastName(contactLastName);
		this.setTaxId(taxId);
		super.setAddressLine(addressLine);
		super.setCity(city);
		super.setState(state);
		super.setZip(zip);
		super.setEmail(emailAddress);
		super.setPhoneNumber(phoneNumber);
		super.setUserName(userName);
		super.setPassword(password);

	}

	public List<Item> getNeededItems() {
		return neededItems;
	}

	public void setNeededItems(List<Item> neededItems) {
		this.neededItems = neededItems;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

}
