package com.example.nagoyamesi.controller;

import java.util.UUID;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.nagoyamesi.entity.PasswordResetToken;
import com.example.nagoyamesi.form.UserPasswordResetForm;
import com.example.nagoyamesi.service.UserService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class PasswordResetController {

	private final UserService userService;
	private final JavaMailSender mailSender;

	public PasswordResetController(UserService userService,JavaMailSender mailSender) {
		this.userService = userService;
		
		this.mailSender = mailSender;
	}

	@GetMapping("/auth/passwordReset")
	public String showForgotPasswordForm() {
		return "auth/passwordReset";
	}

	@PostMapping("/auth/passwordReset")
	public String passwordReset(@RequestParam("email") String email,
			RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest) {

		String token = UUID.randomUUID().toString();
		userService.createPasswordResetTokenForUser(email, token);

		String baseUrl = httpServletRequest.getScheme() + "://" + httpServletRequest.getServerName() +
				(httpServletRequest.getServerPort() == 80 || httpServletRequest.getServerPort() == 443 ? ""
						: ":" + httpServletRequest.getServerPort());
		String resetUrl = baseUrl + "/auth/resetPassword?token=" + token;

		try {
			sendmail(email, resetUrl);
			redirectAttributes.addFlashAttribute("successMessage", "パスワード再発行リンクをメールで送信しました。");
		} catch (MessagingException e) {
			redirectAttributes.addFlashAttribute("errorMessage", "メール送信に失敗しました。");
		}
		
		return "redirect:/auth/passwordReset";
	}

	private void sendmail(String email, String resetUrl) throws MessagingException {
		MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setTo(email);
        helper.setSubject("NAGOYAMESHI：パスワード再発行リンク");
        helper.setText("以下のリンクをクリックしてパスワードを再発行してください: " + resetUrl);

        mailSender.send(message);
	}
	
	@GetMapping("/auth/resetPassword")
    public String showResetPasswordForm(@RequestParam("token") String token, Model model) {
    	
        PasswordResetToken resetToken = userService.getPasswordResetToken(token);
        if (resetToken == null) {
            model.addAttribute("message", "無効なトークンです。");
            return "redirect:/login";
        }
        model.addAttribute("token", token);
        model.addAttribute("userPasswordResetForm", new UserPasswordResetForm());
        return "auth/passwordResetIssue";
    }
	
	@PostMapping("/auth/resetPassword")
	public String processResetPassword(@RequestParam("token") String token,
			@Valid UserPasswordResetForm userPasswordResetForm,
			BindingResult result,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("errorMessage", "フォームにエラーがあります。");
			return "redirect:/auth/resetPassword?token=" + token;
		}

		boolean success = userService.updatePassword(token, userPasswordResetForm.getNewPassword());

		if (success) {
			redirectAttributes.addFlashAttribute("successMessage", "パスワードを更新しました。");
			return "redirect:/login";
		} else {
			redirectAttributes.addFlashAttribute("errorMessage", "パスワードの更新に失敗しました。");
			return "redirect:/auth/resetPassword?token=" + token;
		}
	}
}
