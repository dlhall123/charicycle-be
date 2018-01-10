package com.lmig.gfc.charicycle.config;

import org.springframework.context.annotation.Configuration;

import com.lmig.gfc.charicycle.models.Item;
import com.lmig.gfc.charicycle.services.ItemRepository;

@Configuration
public class NeededItemSeedData {

	public NeededItemSeedData(ItemRepository itemRepo) {

		Item itemOne = itemRepo.save(new Item("Test Category", "Test Description"));

	}
}
