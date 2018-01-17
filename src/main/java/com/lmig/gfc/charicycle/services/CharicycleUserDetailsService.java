package com.lmig.gfc.charicycle.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lmig.gfc.charicycle.models.User;

@Service
public class CharicycleUserDetailsService implements UserDetailsService {
	private UserRepository userRepository;

	public CharicycleUserDetailsService(UserRepository userRepo) {
		userRepository = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(userName);
		if (user == null) {
			throw new UsernameNotFoundException(userName);
		}
		return user;
	}

}
