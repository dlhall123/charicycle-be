package com.lmig.gfc.charicycle.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lmig.gfc.charicycle.models.DonatedItem;

@Repository
public interface DonatedItemRepository extends JpaRepository<DonatedItem, Long> {

}
