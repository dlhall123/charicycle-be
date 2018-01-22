package com.lmig.gfc.charicycle.models;

public class DonatedItemView {

	DonatedItem donatedItem;

	public DonatedItemView(DonatedItem donateditem) {
		this.donatedItem = donateditem;
	}

	public Long getId() {
		return donatedItem.getId();
	}

	public Category getCategory() {
		return donatedItem.getCategory();
	}

	public String getDescription() {
		return donatedItem.getDescription();
	}

	public String getItemImageUrl() {
		return donatedItem.getItemImageUrl();
	}

	public DonorView getDonorView() {
		DonorView donorView = new DonorView(donatedItem.getDonor());
		return donorView;
	}

	// public Long getClaimedCharityId() {
	// return donatedItem.getClaimedCharityId();
	// }

	public Charity getClaimedByCharity() {
		return donatedItem.getClaimedByCharity();
	}
}
