package com.lmig.gfc.charicycle.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.charicycle.models.Charity;
import com.lmig.gfc.charicycle.services.CharityRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/charity/charityForm")
public class CharityApiController {

	@Autowired
	private CharityRepository charityRepository;

	@PostMapping("")
	public Charity create(@RequestBody Charity charity) {
		return charityRepository.save(charity);
	}

	@GetMapping("")
	public List<Charity> getCharityRepository() {
		return charityRepository.findAll();
	}

	

}
