package com.quest.etna.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.quest.etna.model.JwtUserDetails;
import com.quest.etna.model.User;
import com.quest.etna.repositories.UserRepository;
import com.quest.etna.service.UserService;


@Service("userDetailsService")
public class JwtUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@Override
	public JwtUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.print(username + "\n");
		User user = userService.getByUsername(username);
		JwtUserDetails JwtUserDetails = new JwtUserDetails(user);
		System.out.print(JwtUserDetails.getUsername());
		System.out.print(JwtUserDetails.getPassword());
		System.out.print("\n");
		return JwtUserDetails;
	}
}
