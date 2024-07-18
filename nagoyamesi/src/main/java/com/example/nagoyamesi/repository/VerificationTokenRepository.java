package com.example.nagoyamesi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyamesi.entity.User;
import com.example.nagoyamesi.entity.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Integer> {
	public VerificationToken findByToken(String token);

	public VerificationToken findByUser(User user);
}
