package com.example.nagoyamesi.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PasswordResetForm {
	@NotNull
	private Integer id;

	@NotBlank(message = "メールアドレスを入力してください。")
	private String email;

}
