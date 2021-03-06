package com.lmig.gfc.charicycle.apis;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.charicycle.models.User;
import com.lmig.gfc.charicycle.services.UserRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/user")
public class UserApiController {
	private UserRepository userRepository;
	private PasswordEncoder encoder;

	public UserApiController(UserRepository userRepository, PasswordEncoder encoder) {
		this.userRepository = userRepository;
		this.encoder = encoder;
	}

	@GetMapping("")
	public User getUser(Authentication auth) {
		User user = (User) auth.getPrincipal();
		String userName = user.getUsername();

		return userRepository.findByUsername(userName);
	}

	@PutMapping("")
	public User updateUser(Authentication auth, @RequestBody User user) {

		User loggedInUser = (User) auth.getPrincipal();
		user.setId(loggedInUser.getId());

		return userRepository.save(user);
	}

	@PostMapping("create")
	public User createUser(@RequestBody User user) {
		String password = user.getPassword();
		String encryptedPassword = encoder.encode(password);
		user.setPassword(encryptedPassword);
		userRepository.save(user);
		return user;
	}

}
