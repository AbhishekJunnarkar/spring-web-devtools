package com.springprojects.springweb.springwebapplication.web.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttributes;

@Component
public class LoginService {

	public boolean validateUser(String user, String password) {
		return (user.equalsIgnoreCase("Abhishek") || user.equalsIgnoreCase("Arnav"))
				&& (password.equals("pw") || password.equals("1212"));
	}

}
