package com.example.nagoyamesi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyamesi.entity.Favorite;
import com.example.nagoyamesi.entity.Restaurant;
import com.example.nagoyamesi.entity.User;

public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {

	public Page<Favorite> findByUserOrderByCreatedAtDesc(User user, Pageable pageable);

	public Favorite findByRestaurantAndUser(Restaurant restaurant, User user);

	public void deleteByUserIdAndRestaurantId(Integer userId, Integer storeId);

	public void deleteByUserId(Integer userId);
}
