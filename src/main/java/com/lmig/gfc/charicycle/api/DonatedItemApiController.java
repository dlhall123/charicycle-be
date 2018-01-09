package com.lmig.gfc.charicycle.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

}
