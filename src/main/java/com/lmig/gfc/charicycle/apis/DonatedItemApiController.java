package com.lmig.gfc.charicycle.apis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.charicycle.models.DonatedItem;
import com.lmig.gfc.charicycle.models.DonatedItemView;
import com.lmig.gfc.charicycle.services.CharityRepository;
import com.lmig.gfc.charicycle.services.DonatedItemRepository;
import com.lmig.gfc.charicycle.services.DonorRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/donatedItems")
public class DonatedItemApiController {
	@Autowired
	private DonatedItemRepository donateRepo;
	@Autowired
	private DonorRepository donorRepo;
	@Autowired
	private CharityRepository charityRepo;

	@PostMapping("{id}")
	public DonatedItem create(@PathVariable Long id, @RequestBody DonatedItem di) {
		di.setDonor(donorRepo.findOne(id));
		return donateRepo.save(di);
	}

	@GetMapping("")
	public List<DonatedItemView> getAll() {
		List<DonatedItem> donatedItems = donateRepo.findAll();
		ArrayList<DonatedItemView> donatedItemViews = new ArrayList<DonatedItemView>();
		for (DonatedItem item : donatedItems) {
			donatedItemViews.add(new DonatedItemView(item));
		}
		return donatedItemViews;
	}

	@DeleteMapping("{id}")
	public DonatedItem delete(@PathVariable Long id) {
		DonatedItem donatedItem = donateRepo.findOne(id);
		donateRepo.delete(id);
		return donatedItem;
	}

	@GetMapping("{id}")
	public DonatedItemView getOne(@PathVariable Long id) {
		DonatedItem donatedItem = donateRepo.findOne(id);
		if (donatedItem != null) {
			DonatedItemView donatedItemView = new DonatedItemView(donatedItem);
			return donatedItemView;
		}
		return null;
	}

	@PutMapping("{id}")
	public DonatedItem update(@RequestBody DonatedItem donatedItem, @PathVariable Long id) {
		donatedItem.setId(id);
		return donateRepo.save(donatedItem);
	}

	// a put mapping was needed to save the donor id back to the donated object and
	// to update the claimedByCharity on the donated item
	// Since the paths were identical, the if condition checks to see if the id send
	// is a charity, if not, it assumes its a donor's id.
	@PutMapping("{otherId}/{id}")
	public DonatedItem update(@RequestBody DonatedItem donatedItem, @PathVariable Long id, @PathVariable Long otherId) {
		if (charityRepo.findOne(otherId) != null) {
			donatedItem.setId(id);
			donatedItem.setClaimedByCharity(charityRepo.findOne(otherId));
			return donateRepo.save(donatedItem);
		} else {
			donatedItem.setId(id);
			donatedItem.setDonor(donorRepo.findOne(otherId));
			return donateRepo.save(donatedItem);
		}
	}

}
