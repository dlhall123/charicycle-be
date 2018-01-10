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

	@Column(length = 75, nullable = true)
	private String taxId;

	@Column(nullable = true)
	private String address;

	@Column(nullable = true)
	private String contactName;

	@Column(nullable = true)
	private String emailAddress;

	@OneToMany(mappedBy = "charity") // One charity has many Needed Items
	private List<Item> neededItems;

	public Charity() {
	};

	public Charity(String organizationName, String taxId, String address,
			 String contactName, String emailAddress) {
			this.organizationName = organizationName;
			this.taxId = taxId;
			this.address = address;
			this.contactName = contactName;
			this.emailAddress = emailAddress;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
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

}
