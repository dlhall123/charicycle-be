package com.lmig.gfc.charicycle.config;


import org.springframework.context.annotation.Configuration;

import com.lmig.gfc.charicycle.models.Charity;
import com.lmig.gfc.charicycle.models.Donor;
import com.lmig.gfc.charicycle.services.CharityRepository;
import com.lmig.gfc.charicycle.services.DonorRepository;


@Configuration
public class SeedData {

	public SeedData(CharityRepository charityRepository, DonorRepository donorRepository) {

	Charity charity = charityRepository.save(new Charity("Goodwill", "12-3456789",
	"100 E. Main Street Carmel IN 46032", "John Doe", "johndoe@comcast.net"));

	Donor donor = donorRepository.save(new Donor("Lisa inc", "Lisa", "Forrest", "100 E. Main", "Carmel", "IN", "46032", "317-555-5555", "lisalisa@comcast.net"));
		
	
			
			
	}

}
