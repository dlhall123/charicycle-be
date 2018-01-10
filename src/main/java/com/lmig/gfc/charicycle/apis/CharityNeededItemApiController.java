package com.lmig.gfc.charicycle.apis;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.charicycle.models.Charity;
import com.lmig.gfc.charicycle.models.Item;
import com.lmig.gfc.charicycle.services.CharityRepository;
import com.lmig.gfc.charicycle.services.ItemRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/charity/{charityId}/neededItems")
public class CharityNeededItemApiController {

	private CharityRepository charityRepo;
	private ItemRepository itemRepo;

	public CharityNeededItemApiController(CharityRepository charityRepo, ItemRepository itemRepo) {
		this.charityRepo = charityRepo;
		this.itemRepo = itemRepo;
	}

	@PostMapping("")
	public Charity create(@PathVariable Long charityId, @RequestBody Item neededItem) {
		Charity charity = charityRepo.findOne(charityId);
		neededItem.setCharity(charity);
		itemRepo.save(neededItem);
		return charity;
	}

	@GetMapping("")
	public List<Item> getAllByCharity(@PathVariable Long charityId) {

		return itemRepo.findByCharityId(charityId);
	}

}
