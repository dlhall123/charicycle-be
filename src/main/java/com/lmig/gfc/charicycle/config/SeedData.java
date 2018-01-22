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

		// Categories

		categoryRepo.save(new Category("Bedding"));
		categoryRepo.save(new Category("Books/Tapes/Videos"));
		categoryRepo.save(new Category("Clothing"));
		categoryRepo.save(new Category("Cookware"));
		categoryRepo.save(new Category("Electrics & Electronics"));
		categoryRepo.save(new Category("Furniture"));
		categoryRepo.save(new Category("Shoes, Purses & Accessories"));
		categoryRepo.save(new Category("Sporting Goods"));
		categoryRepo.save(new Category("Toys"));
		categoryRepo.save(new Category("Tools"));

		// Donors

		Donor donor = donorRepository.save(new Donor("Lisa inc", "Lisa", "Forrest", "17435 Carey Rd", "Westfield", "IN",
				"46074", "317-555-5555", "lisalisa@comcast.net", "lisa", encoder.encode("password")));
		Donor donor2 = donorRepository.save(new Donor(null, "Joe", "Smith", "110 S Peru St", "Cicero", "IN", "46034",
				"555-555-5555", "email@email.com", "joe", encoder.encode("password")));
		Donor donor3 = donorRepository
				.save(new Donor(null, "Sally", "Sampson", "1050 Century Drive", "Lake Buena Vista", "FL", "32830",
						"555-555-5555", "email@email.com", "sally", encoder.encode("password")));

		// Donated Items

		Category category = categoryRepo.findByName("Bedding").get(0);

		DonatedItem donatedItem = donatedItemRepo.save(new DonatedItem(category, "3 cute Penguins",
				"https://s3-us-west-2.amazonaws.com/charicycle/Penguins.jpg"));
		donatedItem.setDonor(donor);
		donatedItemRepo.save(donatedItem);

		DonatedItem donatedItemTwo = donatedItemRepo.save(new DonatedItem(category, "Comfy Couch",
				"https://images2.roomstogo.com/is/image/roomstogo/lr_sof_10111413_lilithpond~Lilith-Pond-Taupe-Sofa.jpeg?$PDP_Primary_936x650$"));
		donatedItemTwo.setDonor(donor);
		donatedItemRepo.save(donatedItemTwo);

		DonatedItem donatedItemThree = donatedItemRepo.save(new DonatedItem(category, "Baby Crib",
				"https://images-na.ssl-images-amazon.com/images/I/81j6PnZ59KL._SL1500_.jpg"));
		donatedItemThree.setDonor(donor3);
		donatedItemRepo.save(donatedItemThree);

		category = categoryRepo.findByName("Toys").get(0);
		DonatedItem donatedItemFour = donatedItemRepo.save(new DonatedItem(category, "Nintendo Wii",
				"https://images-na.ssl-images-amazon.com/images/I/41xM31QiwdL.jpg"));
		donatedItemFour.setDonor(donor3);
		donatedItemRepo.save(donatedItemFour);

		category = categoryRepo.findByName("Books/Tapes/Videos").get(0);
		DonatedItem donatedItemFive = donatedItemRepo.save(new DonatedItem(category, "Beauty and the Beast",
				"https://images-na.ssl-images-amazon.com/images/I/81SnXE5oYhL._SY445_.jpg"));
		donatedItemFive.setDonor(donor2);
		donatedItemRepo.save(donatedItemFive);

		category = categoryRepo.findByName("Tools").get(0);
		DonatedItem donatedItemSix = donatedItemRepo.save(new DonatedItem(category, "Drill",
				"https://images-na.ssl-images-amazon.com/images/I/71wgBFkcI0L._SL1500_.jpg"));
		donatedItemSix.setDonor(donor);
		donatedItemRepo.save(donatedItemSix);

		// Charities

		Charity charity = charityRepository.save(new Charity("Goodwill", "Fred", "Smith", "12-3456789",
				"100 E. Main Street", "Noblesville", "IN", "46062", "johndoe@comcast.net", "(317)-555-8888", "goodwill",
				encoder.encode("password"), true));
		Charity charity2 = charityRepository.save(new Charity("Gleaners Food Bank", "Fred", "Smith", "35-1483868",
				"3737 Waldemere Ave", "Indianapolis", "IN", "46241", "johnsmith@comcast.net", "(317)-555-5555",
				"salvation", encoder.encode("password"), true));

		Charity charity3 = charityRepository.save(new Charity("Make-a-wish Foundation", "Joe", "Smith", "86-0481941",
				"7330 Woodland Dr", "Indianapolis", "IN", "46278", "johnsmith@comcast.net", "(317)-555-5555", "maw",
				encoder.encode("password"), false));

		Charity charity4 = charityRepository.save(
				new Charity("Give Kids The World", "David", "Smith", "59-2654440", "210 S Bass Rd", "Kissimmee", "FL",
						"34746", "johnsmith@comcast.net", "(317)-555-5555", "gktw", encoder.encode("password"), true));

		// Needed Items

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
