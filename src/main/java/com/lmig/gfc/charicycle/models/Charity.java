package com.lmig.gfc.charicycle.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Charity extends User {
	private static final long serialVersionUID = 1L;

	@Column(length = 75, nullable = true)
	private String taxId;

	private boolean isConfirmed;

	@OneToMany(mappedBy = "charity") // One charity has many Needed Items
	private List<Item> neededItems;

	@JsonIgnore
	@OneToMany(mappedBy = "claimedByCharity")
	private List<DonatedItem> claimedItems;

	public Charity() {
	};

	public Charity(String organizationName, String contactFirstName, String contactLastName, String taxId,
			String addressLine, String city, String state, String zip, String emailAddress, String phoneNumber,
			String userName, String password, boolean isConfirmed) {

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
		this.setConfirmed(isConfirmed);

	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public String getTaxId() {
		return taxId;

	}

	public List<Item> getNeededItems() {
		return neededItems;
	}

	public void setNeededItems(List<Item> neededItems) {
		this.neededItems = neededItems;
	}

	public List<DonatedItem> getClaimedItems() {
		return claimedItems;
	}

	public void setClaimedItems(List<DonatedItem> claimedItems) {
		this.claimedItems = claimedItems;
	}

	public boolean isConfirmed() {
		return isConfirmed;
	}

	public void setConfirmed(boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}
}
