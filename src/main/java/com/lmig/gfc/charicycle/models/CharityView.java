package com.lmig.gfc.charicycle.models;

import java.util.ArrayList;
import java.util.List;

public class CharityView {
	private Charity charity;

	public CharityView(Charity charity) {
		this.charity = charity;
	}

	public Long getId() {
		return charity.getId();
	}

	public String getCompanyName() {
		return charity.getCompanyName();
	}

	public String getTaxId() {
		return charity.getTaxId();
	}

	public String getContactFirstName() {
		return charity.getContactFirstName();
	}

	public String getContactLastName() {
		return charity.getContactLastName();
	}

	public String getAddressLine() {
		return charity.getAddressLine();
	}

	public String getCity() {
		return charity.getCity();
	}

	public String getState() {
		return charity.getState();
	}

	public String getZip() {
		return charity.getZip();
	}

	public String getPhoneNumber() {
		return charity.getPhoneNumber();
	}

	public String getEmail() {
		return charity.getEmail();
	}

	public List<Item> getNeededItems() {
		return charity.getNeededItems();
	}

	public List<DonatedItemView> getClaimedItems() {
		List<DonatedItemView> div = new ArrayList<DonatedItemView>();
		List<DonatedItem> claimedItems = charity.getClaimedItems();
		for (DonatedItem di : claimedItems) {
			div.add(new DonatedItemView(di));
		}
		return div;
	}

}
