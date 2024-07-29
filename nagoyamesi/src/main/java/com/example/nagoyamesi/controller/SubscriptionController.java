package com.example.nagoyamesi.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	@PostMapping("/create")
	public String create(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,
			RedirectAttributes redirectAttributes) {
		User user = userRepository.getReferenceById(userDetailsImpl.getUser().getId());
		userService.upgradeRole(user.getId());

		redirectAttributes.addFlashAttribute("successMessage", "有料会員登録が完了しました。");

		return "redirect:https://buy.stripe.com/test_fZe3eGfzS9Rle0oaEE?locale=ja&__embed_source=buy_btn_1OmuwlIhYmnFrNDSGoP4HbWj";
	}

	
	
	@GetMapping("/delete")
	public String deleteModel(Model model) {
	    return "subscription/delete";
	}
	
	
	@PostMapping("/delete")
	public String delete(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,
			RedirectAttributes redirectAttributes, Model model) {
		User user = userRepository.getReferenceById(userDetailsImpl.getUser().getId());
		userService.downgradeRole(user.getId());

		redirectAttributes.addFlashAttribute("successMessage", "サブスクリプションを解約しました。");

		return "redirect:/";
	}
	


}


