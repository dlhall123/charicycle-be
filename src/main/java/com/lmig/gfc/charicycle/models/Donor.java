package com.lmig.gfc.charicycle.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Donor extends User {
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "donor") // One donor has many Donated Items
	private List<DonatedItem> donatedItems;

	public Donor() {
	}

	public Donor(String companyName, String contactFirstName, String contactLastName, String addressLine, String city,
			String state, String zip, String phoneNumber, String email, String userName, String password) {
		super.setCompanyName(companyName);
		super.setContactFirstName(contactFirstName);
		super.setContactLastName(contactLastName);
		super.setAddressLine(addressLine);
		super.setCity(city);
		super.setState(state);
		super.setZip(zip);
		super.setPhoneNumber(phoneNumber);
		super.setEmail(email);
		super.setUserName(userName);
		super.setPassword(password);
	}

	public List<DonatedItem> getDonatedItems() {
		return donatedItems;
	}

	public void setDonatedItems(List<DonatedItem> donatedItems) {
		this.donatedItems = donatedItems;
	}

}
