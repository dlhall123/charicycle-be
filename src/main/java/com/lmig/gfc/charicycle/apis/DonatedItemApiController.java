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

import com.lmig.gfc.charicycle.models.DonatedItem;
import com.lmig.gfc.charicycle.services.DonatedItemRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/donatedItems")
public class DonatedItemApiController {
	@Autowired
	private DonatedItemRepository donateRepo;

	@PostMapping("")
	public DonatedItem create(@RequestBody DonatedItem di) {
		return donateRepo.save(di);
	}

	@GetMapping("")
	public List<DonatedItem> getAll() {
		return donateRepo.findAll();
	}

	@DeleteMapping("{id}")
	public DonatedItem delete(@PathVariable Long id) {
		DonatedItem donatedItem = donateRepo.findOne(id);
		donateRepo.delete(id);
		return donatedItem;
	}

}
