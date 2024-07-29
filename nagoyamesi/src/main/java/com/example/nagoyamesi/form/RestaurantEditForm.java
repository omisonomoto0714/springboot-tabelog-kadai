package com.example.nagoyamesi.form;

import java.time.LocalTime;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RestaurantEditForm {
	@NotNull
	private Integer id;

	@NotBlank(message = "店舗名を入力してください。")
	private String name;

	private MultipartFile imageFile;

	@NotBlank(message = "説明を入力してください。")
	private String description;

	@NotNull(message = "開店時間を入力してください。")
	private LocalTime openingTime;

	@NotNull(message = "閉店時間を入力してください。")
	private LocalTime closingTime;

	@NotNull(message = "最低予算を入力してください。")
	@Min(value = 1, message = "最低価格は100円以上で設定してください。")
	private Integer lowestPrice;

	@Min(value = 1, message = "最高価格は100円以上で設定してください。")
	@NotNull(message = "最高予算を入力してください。")
	private Integer highestPrice;

	@NotBlank(message = "郵便番号を入力してください。")
	private String postalCode;

	@NotBlank(message = "住所を入力してください。")
	private String address;

	@NotBlank(message = "電話番号を入力してください。")
	private String phoneNumber;

	@NotNull(message = "カテゴリを選択してください。")
	private Integer categoryId;

}
