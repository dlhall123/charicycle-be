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
import com.lmig.gfc.charicycle.services.ItemRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/neededItems")
public class NeededItemApiController {

	@Autowired
	private ItemRepository itemRepo;

	@PostMapping("")
	public Item create(@RequestBody Item neededItem) {
		return itemRepo.save(neededItem);
	}

	@GetMapping("")
	public List<Item> getAll() {
		return itemRepo.findAll();
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		itemRepo.delete(id);
	}

}
