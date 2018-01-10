package com.lmig.gfc.charicycle.apis;


import java.util.List;
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
import com.lmig.gfc.charicycle.models.Donor;
import com.lmig.gfc.charicycle.services.DonorRepository;

@RestController
@RequestMapping("/api/donor")
public class DonorApiController {
	private DonorRepository donorRepo;

	public DonorApiController(DonorRepository donorRepo) {
		this.donorRepo = donorRepo;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Donor create(@RequestBody Donor donor) {
		return donorRepo.save(donor);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("{id}")
	public Donor getOne(@PathVariable Long id) {

		return donorRepo.findOne(id);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("{id}")
	public Donor update(@RequestBody Donor donor, @PathVariable Long id) {
		donor.setId(id);
		return donorRepo.save(donor);

	}

	@CrossOrigin(origins = "http://localhost:4200")

	@DeleteMapping("{id}")
	public Donor delete(@PathVariable Long id) {
		Donor donor = donorRepo.findOne(id);
		donorRepo.delete(id);
		return donor;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("")
	public List<Donor> getDonorRepository() {
		return donorRepo.findAll();
	}
}
