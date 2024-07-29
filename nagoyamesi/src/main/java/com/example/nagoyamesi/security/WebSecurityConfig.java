package com.example.nagoyamesi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests((requests) -> requests
						.requestMatchers("/css/**", "/images/**", "/js/**", "/storage/**", "/", "/signup/**",
								"/restaurants", "/restaurants/{id}", "/restaurants/{id}/reviews", "/stripe/webhook",
								"/auth/passwordReset/**", "/auth/passwordResetIssue/**", "/auth/resetPassword")
						.permitAll() //すべて
						.requestMatchers("/admin/**").hasRole("ADMIN") //管理者のみ
						.anyRequest().authenticated() //それ以外はログインが必須
				)
				.formLogin((form) -> form
						.loginPage("/login") //ログインページ
						.loginProcessingUrl("/login") //ログインフォームの送信先
						.defaultSuccessUrl("/?loggedIn") //ログイン成功時の送信先
						.failureUrl("/login?error") //ログイン失敗時の送f信先
						.permitAll())
				.logout((logout) -> logout
						.logoutSuccessUrl("/?loggedOut") //ログアウト後のリダイレクト先
						.permitAll()

				)
				.csrf(csrf -> csrf.ignoringRequestMatchers("/stripe/webhook"));

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
