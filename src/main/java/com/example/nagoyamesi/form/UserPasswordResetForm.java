package com.example.nagoyamesi.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserPasswordResetForm {

    @NotBlank(message = "新しいパスワードを入力してください。")
    @Size(min = 8, message = "パスワードは8文字以上で入力してください。")
    private String newPassword;

    @NotBlank(message = "確認用パスワードを入力してください。")
    @Size(min = 8, message = "パスワードは8文字以上で入力してください。")
    private String confirmNewPassword;

    // Getters and setters

}
