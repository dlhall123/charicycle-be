package com.lmig.gfc.charicycle.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lmig.gfc.charicycle.models.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

	List<Item> findByCharityId(Long id);
}
