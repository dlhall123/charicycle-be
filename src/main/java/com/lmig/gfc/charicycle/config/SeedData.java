package com.lmig.gfc.charicycle.config;

import org.springframework.context.annotation.Configuration;

import com.lmig.gfc.charicycle.models.Category;
import com.lmig.gfc.charicycle.services.CategoryRepository;

@Configuration
public class SeedData {

	
	public SeedData(CategoryRepository categoryRepo) {
		categoryRepo.save(new Category("Bedding"));
		categoryRepo.save(new Category("Books/Tapes/Videos"));
		categoryRepo.save(new Category("Clothing"));
		categoryRepo.save(new Category("Cookware"));
		categoryRepo.save(new Category("Electrics & Electronics"));
		categoryRepo.save(new Category("Furniture"));
		categoryRepo.save(new Category("Shoes, Purses & Accessories"));
		categoryRepo.save(new Category("Sporting Goods"));
		categoryRepo.save(new Category("Toys"));
		
	}

}
