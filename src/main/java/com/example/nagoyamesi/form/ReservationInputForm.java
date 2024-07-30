package com.example.nagoyamesi.form;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReservationInputForm {
	@NotNull(message = "来店日を選択してください。")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate reservationDate;

	@NotNull(message = "来店時間を選択して下さい。")
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime reservationTime;

	@NotNull(message = "来店人数を入力してください。")
	@Min(value = 1, message = "来店人数は1人以上に設定してください。")
	private Integer numberOfPeople;

	// 来店日を取得する
	//	public LocalDate getReservationDate() {
	//
	//		return getFromReservationDate();
	//	}

	// 来店時間を取得する
	//	public LocalTime getReservationTime() {
	//
	//		return getFromReservationTime();
	//	}

}
