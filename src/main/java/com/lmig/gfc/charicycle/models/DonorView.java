package com.lmig.gfc.charicycle.models;

public class DonorView {

	private Donor donor;

	public DonorView(Donor donor) {
		this.donor = donor;
	}

	public Long getId() {
		return donor.getId();
	}

	public String getCompanyName() {
		return donor.getCompanyName();
	}

	public String getContactFirstName() {
		return donor.getContactFirstName();
	}

	public String getContactLastName() {
		return donor.getContactLastName();
	}

	public String getAddressLine() {
		return donor.getAddressLine();
	}

	public String getCity() {
		return donor.getCity();
	}

	public String getState() {
		return donor.getState();
	}

	public String getZip() {
		return donor.getZip();
	}

	public String getPhoneNumber() {
		return donor.getPhoneNumber();
	}

	public String getEmail() {
		return donor.getEmail();
	}

}
