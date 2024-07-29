package com.example.nagoyamesi.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PasswordResetForm {
	@NotNull
	private Integer id;

	@NotBlank(message = "メールアドレスを入力してください。")
	private String email;
	
	
	@NotBlank(message = "新しいパスワードを入力してください。")
	private String password;

}
