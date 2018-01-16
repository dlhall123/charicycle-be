package com.lmig.gfc.charicycle.models;

public class NeededItemView {

	private Item item;

	public NeededItemView(Item item) {
		this.item = item;
	}

	public Long getId() {
		return item.getId();
	}

	public Category getCategory() {
		return item.getCategory();
	}

	public String getDescription() {
		return item.getDescription();
	}

	public Charity getCharity() {
		return item.getCharity();
	}
}
