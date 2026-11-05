package com.apik.movies.controller;

import com.apik.movies.model.User;
import com.apik.movies.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/")
	public String homePage() {
		return "index";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@PostMapping("/login") 
	public String loginSubmit(@RequestParam String username, 
	                          @RequestParam String password, 
	                          Model model) {
		
		// PRINT DEBUG INFO TO CONSOLE
		System.out.println("========================================");
		System.out.println("FORM USERNAME RECEIVED: [" + username + "]");
		System.out.println("FORM PASSWORD RECEIVED: [" + password + "]");
		
		User user = userRepository.findByUsernameAndPassword(username, password);
		
		if(user != null) {
			System.out.println("DATABASE: User found successfully!");
			System.out.println("========================================");
			model.addAttribute("username", user.getUsername());
			return "home"; 
		} else {
			System.out.println("DATABASE: NO matching user found (returned null)");
			System.out.println("========================================");
			model.addAttribute("message", "Invalid username or password");
			return "login"; 
		}
	}
}