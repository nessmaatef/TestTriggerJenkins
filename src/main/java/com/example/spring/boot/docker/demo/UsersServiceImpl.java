package com.example.spring.boot.docker.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl {

	@Autowired
	private UsersRepository usersRepository;

	public String getLname(String fname) {
		Users user = usersRepository.findByFname(fname);
		if (user != null)
			return user.getLname();
		else
			return "User " + fname + " is not found;";
	}
}
