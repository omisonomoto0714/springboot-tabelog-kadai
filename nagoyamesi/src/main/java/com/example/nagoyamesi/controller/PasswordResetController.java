package com.example.nagoyamesi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.nagoyamesi.form.PasswordResetForm;
import com.example.nagoyamesi.repository.UserRepository;
import com.example.nagoyamesi.service.UserService;

@Controller
public class PasswordResetController {
	private final UserService userService;
	private final UserRepository userRepository;
	
	public PasswordResetController(UserService userService, UserRepository userRepository) {
		this.userService = userService;
		this.userRepository = userRepository;
	}
	
    @GetMapping("/auth/passwordReset")
    public String showForgotPasswordForm(Model model) {
    	model.addAttribute("passwordResetForm", new PasswordResetForm());
        return "auth/passwordReset";
    }
	

}
