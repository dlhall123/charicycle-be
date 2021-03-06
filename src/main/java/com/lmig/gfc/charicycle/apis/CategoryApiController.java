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

import com.lmig.gfc.charicycle.models.Category;
import com.lmig.gfc.charicycle.services.CategoryRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/category")
public class CategoryApiController {
	private CategoryRepository categoryRepo;

	public CategoryApiController(CategoryRepository categoryRepo) {
		this.categoryRepo = categoryRepo;
	}

	@GetMapping("")
	public List<Category> getAll() {

		return categoryRepo.findAll();
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Category create(@RequestBody Category category) {
		return categoryRepo.save(category);
	}

	@GetMapping("{id}")
	public Category getOne(@PathVariable Long id) {

		return categoryRepo.findOne(id);
	}

	@PutMapping("{id}")
	public Category update(@RequestBody Category category, @PathVariable Long id) {
		category.setId(id);
		return categoryRepo.save(category);

	}

	@DeleteMapping("{id}")
	public Category delete(@PathVariable Long id) {
		Category category = categoryRepo.findOne(id);
		categoryRepo.delete(id);
		return category;
	}

}
