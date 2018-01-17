package com.lmig.gfc.charicycle.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmig.gfc.charicycle.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUserName(String userName);

}
