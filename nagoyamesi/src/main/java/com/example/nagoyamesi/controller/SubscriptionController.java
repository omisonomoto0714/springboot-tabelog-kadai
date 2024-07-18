package com.example.nagoyamesi.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.nagoyamesi.entity.User;
import com.example.nagoyamesi.repository.UserRepository;
import com.example.nagoyamesi.security.UserDetailsImpl;
import com.example.nagoyamesi.service.StripeService;
import com.example.nagoyamesi.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/subscription")
public class SubscriptionController {
	private final UserRepository userRepository;
	private final UserService userService;
	private final StripeService stripeService;

	public SubscriptionController(UserRepository userRepository, UserService userService, StripeService stripeService) {
		this.userRepository = userRepository;
		this.userService = userService;
		this.stripeService = stripeService;

	}

	@GetMapping("/register")
	public String index(Model model, HttpServletRequest httpServletRequest,
			@AuthenticationPrincipal UserDetailsImpl userDetailsImpl) {
		User user = userDetailsImpl.getUser();
		String sessionId = stripeService.createStripeSession(httpServletRequest, user);
		model.addAttribute("sessionId", sessionId);
		return "subscription/register";
	}

	@GetMapping("/delete")
	public String delete(Model model) {

		return "subscription/deletion";
	}

}
