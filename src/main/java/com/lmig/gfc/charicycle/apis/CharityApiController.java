package com.lmig.gfc.charicycle.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.lmig.gfc.charicycle.models.Charity;
import com.lmig.gfc.charicycle.models.DonatedItem;
import com.lmig.gfc.charicycle.models.Donor;
import com.lmig.gfc.charicycle.models.Item;
import com.lmig.gfc.charicycle.services.CharityRepository;
import com.lmig.gfc.charicycle.services.DonatedItemRepository;
import com.lmig.gfc.charicycle.services.DonorRepository;
import com.lmig.gfc.charicycle.services.ItemRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/charity")
public class CharityApiController {

@Autowired
private CharityRepository charityRepository;

private ItemRepository itemRepository;
	
public CharityApiController(CharityRepository charityRepository, ItemRepository itemRepository) {
 	this.charityRepository = charityRepository;
	this.itemRepository = itemRepository;
}
	

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Charity create(@RequestBody Charity charity) {
		return charityRepository.save(charity);
	}
	
	@GetMapping("")
	public List<Charity> getCharityRepository() {
		return charityRepository.findAll();
	}
	
	@GetMapping("{id}")
	public Charity geOne(@PathVariable Long id) {
		return charityRepository.findOne(id);
	}

	@PutMapping("{id}")
	public Charity update(@RequestBody Charity charity, @PathVariable Long id) {
		charity.setId(id);
		return charityRepository.save(charity);

	}

	@DeleteMapping("{id}")
	public Charity delete(@PathVariable Long id) {
		Charity charity = charityRepository.findOne(id);
		if(charity.getNeededItems() !=null) {
			for (Item ni : charity.getNeededItems()) {
				itemRepository.delete(ni.getId());
			}			
		}
		charityRepository.delete(id);
		return charity;
	}
}
			
	


			
	




