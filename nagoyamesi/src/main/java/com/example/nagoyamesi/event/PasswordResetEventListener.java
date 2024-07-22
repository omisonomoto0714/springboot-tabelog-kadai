package com.example.nagoyamesi.event;

import java.util.UUID;

import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.example.nagoyamesi.entity.User;
import com.example.nagoyamesi.service.VerificationTokenService;

public class PasswordResetEventListener {
	private final VerificationTokenService verificationTokenService;
	private final JavaMailSender javaMailSender;

	public PasswordResetEventListener(VerificationTokenService verificationTokenService, JavaMailSender mailSender) {
		this.verificationTokenService = verificationTokenService;
		this.javaMailSender = mailSender;
	}

	@EventListener
	private void onPasswordResetEvent(PasswordResetEvent passwordResetEvent) {
		User user = passwordResetEvent.getUser();
		String token = UUID.randomUUID().toString();
		verificationTokenService.create(user, token);

		String recipientAddress = user.getEmail();
		String subject = "メール認証";
		String confirmationUrl = passwordResetEvent.getRequestUrl() + "/verify?token=" + token;
		String message = "以下のリンクをクリックしてパスワードのリセットを完了してください。";

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(recipientAddress);
		mailMessage.setSubject(subject);
		mailMessage.setText(message + "\n" + confirmationUrl);

		javaMailSender.send(mailMessage);
	}
}
