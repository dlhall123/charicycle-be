package com.lmig.gfc.charicycle.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.lmig.gfc.charicycle.models.Category;
import com.lmig.gfc.charicycle.models.Charity;
import com.lmig.gfc.charicycle.models.DonatedItem;
import com.lmig.gfc.charicycle.models.Donor;
import com.lmig.gfc.charicycle.models.Item;
import com.lmig.gfc.charicycle.services.CategoryRepository;
import com.lmig.gfc.charicycle.services.CharityRepository;
import com.lmig.gfc.charicycle.services.DonatedItemRepository;
import com.lmig.gfc.charicycle.services.DonorRepository;
import com.lmig.gfc.charicycle.services.ItemRepository;

@Configuration
public class SeedData {

	public SeedData(CategoryRepository categoryRepo, CharityRepository charityRepository,
			DonorRepository donorRepository, DonatedItemRepository donatedItemRepo, ItemRepository itemRepo,
			PasswordEncoder encoder) {
		categoryRepo.save(new Category("Bedding"));
		categoryRepo.save(new Category("Books/Tapes/Videos"));
		categoryRepo.save(new Category("Clothing"));
		categoryRepo.save(new Category("Cookware"));
		categoryRepo.save(new Category("Electrics & Electronics"));
		categoryRepo.save(new Category("Furniture"));
		categoryRepo.save(new Category("Shoes, Purses & Accessories"));
		categoryRepo.save(new Category("Sporting Goods"));
		categoryRepo.save(new Category("Toys"));

		Donor donor = donorRepository.save(new Donor("Lisa inc", "Lisa", "Forrest", "100 E. Main", "Carmel", "IN",
				"46032", "317-555-5555", "lisalisa@comcast.net", "lisa", encoder.encode("password")));

		Charity charity = charityRepository.save(
				new Charity("Goodwill", "Fred", "Smith", "35-1483868", "100 E. Main Street", "Carmel", "IN", "46032",
						"johndoe@comcast.net", "(317)-555-8888", "goodwill", encoder.encode("password"), true));

		// Donated Item Seed Data
		Category category = categoryRepo.findByName("Bedding").get(0);
		Donor donor2 = donorRepository.save(new Donor(null, "Joe", "Smith", "684 Hwy 74", "Indianapolis", "IN", "46220",
				"555-555-5555", "email@email.com", "joe", encoder.encode("password")));
		DonatedItem donatedItem = donatedItemRepo.save(new DonatedItem(category, "3 cute Penguins",
				"https://s3-us-west-2.amazonaws.com/charicycle/Penguins.jpg"));
		donatedItem.setDonor(donor);
		donatedItemRepo.save(donatedItem);

		DonatedItem donatedItemTwo = donatedItemRepo.save(new DonatedItem(category, "Comfy Couch", null));
		donatedItemTwo.setDonor(donor);
		donatedItemRepo.save(donatedItemTwo);

		Donor donor3 = donorRepository.save(new Donor(null, "Sally", "Sampson", "655 Mason Street", "Greenwood", "IN",
				"46143", "555-555-5555", "email@email.com", "blow", encoder.encode("password")));
		DonatedItem donatedItemThree = donatedItemRepo.save(new DonatedItem(category, "Baby Crib", null));
		donatedItemThree.setDonor(donor3);
		donatedItemRepo.save(donatedItemThree);

		// Needed Item Seed Data

		Charity charity2 = charityRepository.save(
				new Charity("Salvation Army", "Fred", "Smith", "12-3456789", "100 E. Main", "Carmel", "IN", "46032",
						"johnsmith@comcast.net", "(317)-555-5555", "salvation", encoder.encode("password"), true));

		Item itemOne = itemRepo.save(new Item(category, "My charity needs a fridge"));
		itemOne.setCharity(charity2);
		itemRepo.save(itemOne);

		Donor admin = new Donor();
		admin.setAdmin(true);
		admin.setUsername("admin");
		admin.setPassword(encoder.encode("password"));
		admin.setContactFirstName("Admin");
		admin.setContactLastName("Admin");
		admin.setEmail("admin@admin.com");
		donorRepository.save(admin);

	}

}
