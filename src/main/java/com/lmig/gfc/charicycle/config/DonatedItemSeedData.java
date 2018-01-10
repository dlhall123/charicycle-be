package com.lmig.gfc.charicycle.config;

import org.springframework.context.annotation.Configuration;

import com.lmig.gfc.charicycle.models.DonatedItem;
import com.lmig.gfc.charicycle.models.Donor;
import com.lmig.gfc.charicycle.services.DonatedItemRepository;
import com.lmig.gfc.charicycle.services.DonorRepository;

@Configuration
public class DonatedItemSeedData {

	public DonatedItemSeedData(DonatedItemRepository donatedItemRepo, DonorRepository donorRepo) {

		Donor donor = donorRepo.save(new Donor(null, "Joe", "Smith", null, null, null, null, null, "email@emial.com"));
		DonatedItem donatedItem = donatedItemRepo.save(new DonatedItem("Test Category", "Test Description"));
		donatedItem.setDonor(donor);
		donatedItemRepo.save(donatedItem);
	}
}
