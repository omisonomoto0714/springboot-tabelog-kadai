package com.example.nagoyamesi.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class VerificationTokenEditForm {
	@NotBlank(message = "メールアドレスを入力してください。")
	private String email;

}
