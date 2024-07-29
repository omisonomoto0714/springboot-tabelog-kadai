package com.example.nagoyamesi.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.nagoyamesi.entity.User;
import com.example.nagoyamesi.entity.VerificationToken;
import com.example.nagoyamesi.repository.VerificationTokenRepository;

@Service
public class VerificationTokenService {
	private final VerificationTokenRepository verificationTokenRepository;

	public VerificationTokenService(VerificationTokenRepository verificationTokenRepository) {
		this.verificationTokenRepository = verificationTokenRepository;
	}

	@Transactional
	public void create(User user, String token) {
		VerificationToken verificationToken = new VerificationToken();

		verificationToken.setUser(user);
		verificationToken.setToken(token);

		verificationTokenRepository.save(verificationToken);
	}

	public VerificationToken getVerificationToken(String token) {
		return verificationTokenRepository.findByToken(token);
	}

}
