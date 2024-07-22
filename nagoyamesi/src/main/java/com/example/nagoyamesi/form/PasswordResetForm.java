package com.example.nagoyamesi.form;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data

public class PasswordResetForm {
	@NotNull
	private Integer id;

	@NotBlank(message = "メールアドレスを入力してください。")
	private String email;
	
	
	@NotBlank(message = "パスワードを入力してください。")
	@Length(min = 8, message = "パスワードは8文字以上で入力してください。")
	private String password;


}
