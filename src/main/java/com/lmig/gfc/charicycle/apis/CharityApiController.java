package com.lmig.gfc.charicycle.apis;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.charicycle.repositories.CharityRepository;

@RestController
@RequestMapping("/api/charity")
public class CharityApiController {

	
	private CharityRepository charityRepository;

	public CharityApiController(CharityRepository charityRepository) {
		this.setCharityRepository(charityRepository);

			}

	public CharityRepository getCharityRepository() {
		return charityRepository;
	}

	public void setCharityRepository(CharityRepository charityRepository) {
		this.charityRepository = charityRepository;
	}
		

	
	}	
	

