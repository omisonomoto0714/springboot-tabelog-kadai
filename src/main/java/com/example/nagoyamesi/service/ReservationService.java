package com.example.nagoyamesi.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.nagoyamesi.entity.Reservation;
import com.example.nagoyamesi.entity.Restaurant;
import com.example.nagoyamesi.entity.User;
import com.example.nagoyamesi.form.ReservationRegisterForm;
import com.example.nagoyamesi.repository.ReservationRepository;
import com.example.nagoyamesi.repository.RestaurantRepository;
import com.example.nagoyamesi.repository.UserRepository;

@Service
public class ReservationService {
	private final ReservationRepository reservationRepository;
	private final RestaurantRepository restaurantRepository;
	private final UserRepository userRepository;

	public ReservationService(ReservationRepository reservationRepository, RestaurantRepository restaurantRepository,
			UserRepository userRepository) {
		this.reservationRepository = reservationRepository;
		this.restaurantRepository = restaurantRepository;
		this.userRepository = userRepository;
	}

	@Transactional
	public void create(ReservationRegisterForm reservationRegisterForm) {
		Reservation reservation = new Reservation();
		Restaurant restaurant = restaurantRepository.getReferenceById(reservationRegisterForm.getRestaurantId());
		User user = userRepository.getReferenceById(reservationRegisterForm.getUserId());
		LocalDate reservationDate = LocalDate.parse(reservationRegisterForm.getReservationDate());
		LocalTime reservationTime = LocalTime.parse(reservationRegisterForm.getReservationTime());

		reservation.setRestaurant(restaurant);
		reservation.setUser(user);
		reservation.setReservationDate(reservationDate);
		reservation.setReservationTime(reservationTime);
		reservation.setNumberOfPeople(reservationRegisterForm.getNumberOfPeople());

		reservationRepository.save(reservation);

	}

	public boolean isWithinOpeningTime(String fromReservationTime, String openingTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime parsedOpeningTime = LocalTime.parse(openingTime, formatter);
		LocalTime parsedFromReservationTime = LocalTime.parse(fromReservationTime, formatter);
		return parsedFromReservationTime.isAfter(parsedOpeningTime)
				|| parsedFromReservationTime.equals(parsedOpeningTime);
	}

	public boolean isWithinClosingTime(String fromReservationTime, String closing) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime parsedClosingTime = LocalTime.parse(closing, formatter);
		LocalTime parsedFromReservationTime = LocalTime.parse(fromReservationTime, formatter);
		return parsedFromReservationTime.isBefore(parsedClosingTime)
				|| parsedFromReservationTime.equals(parsedClosingTime);
	}

}
