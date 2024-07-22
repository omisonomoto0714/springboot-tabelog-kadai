package com.example.nagoyamesi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.nagoyamesi.entity.User;
import com.example.nagoyamesi.form.PasswordResetForm;
import com.example.nagoyamesi.repository.UserRepository;
import com.example.nagoyamesi.service.UserService;

import jakarta.validation.Valid;

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
	

    @PostMapping("/passwordReset")
    public String handlePasswordReset(@Valid PasswordResetForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "auth/passwordReset";
        }

        // ユーザーの検索
        User user = userRepository.findByEmail(form.getEmail());
        if (user == null) {
            result.rejectValue("email", "error.passwordResetForm", "該当するメールアドレスが見つかりません。");
            return "auth/passwordReset";
        }

        // パスワード更新
        userService.updatePassword(user, form.getPassword());

        model.addAttribute("message", "パスワードが正常に更新されました。");
        return "redirect:/login?updateSuccess";
    }
}
