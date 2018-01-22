package com.lmig.gfc.charicycle.apis;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.charicycle.models.DonatedItem;
import com.lmig.gfc.charicycle.models.Donor;
import com.lmig.gfc.charicycle.services.DonatedItemRepository;
import com.lmig.gfc.charicycle.services.DonorRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/donor/{donorId}/donatedItems")
public class DonorDonatedItemApiController {

	private DonorRepository donorRepo;
	private DonatedItemRepository donatedItemRepo;

	public DonorDonatedItemApiController(DonorRepository donorRepo, DonatedItemRepository donatedItemRepo) {
		this.donorRepo = donorRepo;
		this.donatedItemRepo = donatedItemRepo;
	}

	@PostMapping("")
	public Donor create(@PathVariable Long donorId, @RequestBody DonatedItem donatedItem) {
		Donor donor = donorRepo.findOne(donorId);
		donatedItem.setDonor(donor);
		donatedItemRepo.save(donatedItem);
		return donor;
	}

	@GetMapping("")
	public List<DonatedItem> getAllItemsByDonor(@PathVariable Long donorId) {
		System.out.println(donorId);
		return donatedItemRepo.findByDonorId(donorId);
	}

}
