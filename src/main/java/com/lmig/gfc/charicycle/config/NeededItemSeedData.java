package com.lmig.gfc.charicycle.config;

import org.springframework.context.annotation.Configuration;

import com.lmig.gfc.charicycle.models.Charity;
import com.lmig.gfc.charicycle.models.Item;
import com.lmig.gfc.charicycle.services.CharityRepository;
import com.lmig.gfc.charicycle.services.ItemRepository;

@Configuration
public class NeededItemSeedData {

	public NeededItemSeedData(ItemRepository itemRepo, CharityRepository charityRepo) {

		Charity charity = charityRepo.save(new Charity("My charity", null, null, null, null));
		Item itemOne = itemRepo.save(new Item("Test Category", "Test Description"));
		itemOne.setCharity(charity);
		itemRepo.save(itemOne);
	}
}
