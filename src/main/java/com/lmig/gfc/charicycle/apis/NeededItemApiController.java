package com.lmig.gfc.charicycle.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.charicycle.models.Item;
import com.lmig.gfc.charicycle.services.CharityRepository;
import com.lmig.gfc.charicycle.services.ItemRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/neededItems")
public class NeededItemApiController {

	@Autowired
	private ItemRepository itemRepo;
	@Autowired
	private CharityRepository charityRepo;

	@PostMapping("{id}")
	public Item create(@PathVariable Long id, @RequestBody Item neededItem) {
		System.out.println(id);
		neededItem.setCharity(charityRepo.findOne(id));
		return itemRepo.save(neededItem);
	}

	@GetMapping("")
	public List<Item> getAll() {
		return itemRepo.findAll();
	}

	@DeleteMapping("{id}")
	public Item delete(@PathVariable Long id) {
		Item item = itemRepo.findOne(id);
		itemRepo.delete(id);
		return item;
	}

}
