package com.lmig.gfc.charicycle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.lmig.gfc.charicycle.services.CharicycleUserDetailsService;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	private CharicycleUserDetailsService userDetailsService;

	public SecurityConfiguration(CharicycleUserDetailsService uds) {
		this.userDetailsService = uds;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				// allow access without auth to the following routes
				.antMatchers(HttpMethod.GET, "/img/**", "/css/**", "/js/**").permitAll()
				.antMatchers(HttpMethod.POST, "/api/users/new").permitAll()
				.antMatchers(HttpMethod.PUT, "/api/session/mine").permitAll().antMatchers(HttpMethod.OPTIONS)
				.permitAll().anyRequest().authenticated().and().csrf().disable();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public UserDetailsService userDetailsService() {
		return userDetailsService;
	}

}
