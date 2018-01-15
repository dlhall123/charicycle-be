package com.lmig.gfc.charicycle.config;

import org.springframework.context.annotation.Configuration;

import com.lmig.gfc.charicycle.models.Category;
import com.lmig.gfc.charicycle.models.Charity;
import com.lmig.gfc.charicycle.models.Item;
import com.lmig.gfc.charicycle.services.CategoryRepository;
import com.lmig.gfc.charicycle.services.CharityRepository;
import com.lmig.gfc.charicycle.services.ItemRepository;

@Configuration
public class NeededItemSeedData {

	public NeededItemSeedData(ItemRepository itemRepo, CharityRepository charityRepo, CategoryRepository catRepo) {
		Category category = new Category();
		category.setName("Seed Category");
		catRepo.save(category);
		Charity charity = charityRepo.save(new Charity("Goodwill", "Sara", "Plain And Tall", "12-3456789",
				"100 E. Main Street",  "Carmel",  "IN", "46032", "johndoe@comcast.net", "(317)-555-8888"));

		Item itemOne = itemRepo.save(new Item(category, "My charity needs a fridge"));
		itemOne.setCharity(charity);
		itemRepo.save(itemOne);
	}

}
