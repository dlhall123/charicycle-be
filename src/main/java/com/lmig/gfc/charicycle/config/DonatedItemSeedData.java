package com.lmig.gfc.charicycle.config;

import org.springframework.context.annotation.Configuration;

import com.lmig.gfc.charicycle.models.Category;
import com.lmig.gfc.charicycle.models.DonatedItem;
import com.lmig.gfc.charicycle.models.Donor;
import com.lmig.gfc.charicycle.services.CategoryRepository;
import com.lmig.gfc.charicycle.services.DonatedItemRepository;
import com.lmig.gfc.charicycle.services.DonorRepository;

@Configuration
public class DonatedItemSeedData {

	public DonatedItemSeedData(DonatedItemRepository donatedItemRepo, DonorRepository donorRepo,
			CategoryRepository catRepo) {
		Category category = new Category();
		category.setName("Seed Category");
		catRepo.save(category);
		Donor donor = donorRepo.save(new Donor(null, "Joe", "Smith", null, null, null, null, "555-555-5555",
				"email@email.com", "joe", "password"));
		DonatedItem donatedItem = donatedItemRepo.save(new DonatedItem(category, "3 cute Penguins",
				"https://s3-us-west-2.amazonaws.com/charicycle/Penguins.jpg"));
		donatedItem.setDonor(donor);
		donatedItemRepo.save(donatedItem);

		DonatedItem donatedItemTwo = donatedItemRepo.save(new DonatedItem(category, "Comfy Couch", null));
		donatedItemTwo.setDonor(donor);
		donatedItemRepo.save(donatedItemTwo);

	}

}
