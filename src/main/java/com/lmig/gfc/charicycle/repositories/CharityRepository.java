package com.lmig.gfc.charicycle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lmig.gfc.charicycle.models.Charity;


	@Repository
	public interface CharityRepository extends JpaRepository<Charity, Long> {

	}


