package com.lmig.gfc.charicycle.config;

import org.springframework.context.annotation.Configuration;

import com.lmig.gfc.charicycle.models.Category;
import com.lmig.gfc.charicycle.models.Charity;
import com.lmig.gfc.charicycle.models.Donor;
import com.lmig.gfc.charicycle.services.CategoryRepository;
import com.lmig.gfc.charicycle.services.CharityRepository;
import com.lmig.gfc.charicycle.services.DonorRepository;

@Configuration
public class SeedData {

	public SeedData(CategoryRepository categoryRepo, CharityRepository charityRepository,
			DonorRepository donorRepository) {
		categoryRepo.save(new Category("Bedding"));
		categoryRepo.save(new Category("Bedding"));
		categoryRepo.save(new Category("Bedding"));
		categoryRepo.save(new Category("Bedding"));
		categoryRepo.save(new Category("Bedding"));
		categoryRepo.save(new Category("Bedding"));
		categoryRepo.save(new Category("Bedding"));
		categoryRepo.save(new Category("Bedding"));
		categoryRepo.save(new Category("Bedding"));
		categoryRepo.save(new Category("Bedding"));
		categoryRepo.save(new Category("Bedding"));
		categoryRepo.save(new Category("Bedding"));
		categoryRepo.save(new Category("Bedding"));
		categoryRepo.save(new Category("Books/Tapes/Videos"));
		categoryRepo.save(new Category("Clothing"));
		categoryRepo.save(new Category("Cookware"));
		categoryRepo.save(new Category("Electrics & Electronics"));
		categoryRepo.save(new Category("Furniture"));
		categoryRepo.save(new Category("Shoes, Purses & Accessories"));
		categoryRepo.save(new Category("Sporting Goods"));
		categoryRepo.save(new Category("Toys"));

		Charity charity = charityRepository
				.save(new Charity("Goodwill", "Fred", "Smith", "12-3456789", "100 E. Main Street", "Carmel", "IN",
						"46032", "johndoe@comcast.net", "(317)-555-8888", "goodwill", "password"));

		Donor donor = donorRepository.save(new Donor("Lisa inc", "Lisa", "Forrest", "100 E. Main", "Carmel", "IN",
				"46032", "317-555-5555", "lisalisa@comcast.net", "lisa", "password"));

	}

}
