package com.example.nagoyamesi.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.nagoyamesi.entity.Role;
import com.example.nagoyamesi.entity.User;
import com.example.nagoyamesi.form.PasswordResetForm;
import com.example.nagoyamesi.form.SignupForm;
import com.example.nagoyamesi.form.UserEditForm;
import com.example.nagoyamesi.repository.RoleRepository;
import com.example.nagoyamesi.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;

	}

	@Transactional
	public User create(SignupForm signupForm) {
		User user = new User();
		Role role = roleRepository.findByName("ROLE_GENERAL");

		user.setName(signupForm.getName());
		user.setFurigana(signupForm.getFurigana());
		user.setPostalCode(signupForm.getPostalCode());
		user.setAddress(signupForm.getAddress());
		user.setPhoneNumber(signupForm.getPhoneNumber());
		user.setEmail(signupForm.getEmail());
		user.setPassword(passwordEncoder.encode(signupForm.getPassword()));
		user.setRoleId(role);
		user.setEnabled(false);

		return userRepository.save(user);
	}

	@Transactional
	public void update(UserEditForm userEditForm) {
		User user = userRepository.getReferenceById(userEditForm.getId());

		user.setName(userEditForm.getName());
		user.setFurigana(userEditForm.getFurigana());
		user.setPostalCode(userEditForm.getPostalCode());
		user.setAddress(userEditForm.getAddress());
		user.setPhoneNumber(userEditForm.getPhoneNumber());
		user.setEmail(userEditForm.getEmail());

		userRepository.save(user);
	}

	//パスワードリセット機能
	@Transactional
	public void updatePassword(PasswordResetForm passwordResetForm) {
		User user = userRepository.findByEmail(passwordResetForm.getEmail());

				user.setPassword(passwordEncoder.encode(passwordResetForm.getPassword()));
		user.setEnabled(true);

		userRepository.save(user);
	}

	@Transactional
	public void enableUser(User user) {
		user.setEnabled(true);
		userRepository.save(user);
	}

	@Transactional
	public void upgradeRole(Integer userId) {
		User user = userRepository.getReferenceById(userId);
		Role role = roleRepository.findByName("ROLE_PREMIUM");

		user.setRoleId(role);
		user.setEnabled(true);

		userRepository.save(user);

	}

	@Transactional
	public void downgradeRole(Integer userId) {

		User user = userRepository.getReferenceById(userId);
		Role role = roleRepository.findByName("ROLE_FREEGENERAL");

		user.setRoleId(role);
		user.setEnabled(true);

		userRepository.save(user);

	}

	//メールアドレスが登録してあるか
	public boolean isEmailRegistered(String email) {
		User user = userRepository.findByEmail(email);
		return user != null;
	}

	//パスワードが確認用と一致しているか
	public boolean isSamePassword(String password, String passwordConfirmation) {
		return password.equals(passwordConfirmation);
	}

	//メールアドレスが変更されてるかチェック
	public boolean isEmailChanged(UserEditForm userEditForm) {
		User currentUser = userRepository.getReferenceById(userEditForm.getId());
		return !userEditForm.getEmail().equals(currentUser.getEmail());
	}
}