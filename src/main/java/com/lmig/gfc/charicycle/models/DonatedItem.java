package com.lmig.gfc.charicycle.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class DonatedItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String category;
	private String description;

	private String itemImageUrl;

	@JsonIgnore
	@ManyToOne
	private Donor donor;

	public DonatedItem(String category, String description) {
		this.category = category;
		this.description = description;
	}

	public DonatedItem() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getItemImageUrl() {
		return itemImageUrl;
	}

	public void setItemImageUrl(String itemImageUrl) {
		this.itemImageUrl = itemImageUrl;
	}

	public Donor getDonor() {
		return donor;
	}

	public void setDonor(Donor donor) {
		this.donor = donor;
	}
}
