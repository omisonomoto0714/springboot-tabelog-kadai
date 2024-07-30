package com.example.nagoyamesi.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyamesi.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

	public Page<Restaurant> findByNameLike(String keyword, Pageable pageable);

	//店舗名、住所
	public Page<Restaurant> findByNameLikeOrAddressLikeOrderByCreatedAtDesc(String nameKeyword, String addressKeyword,
			Pageable pageable);

	public Page<Restaurant> findByNameLikeOrAddressLikeOrderByLowestPriceAsc(String nameKeyword, String addressKeyword,
			Pageable pageable);

	//最低価格で検索
	public Page<Restaurant> findByLowestPriceLessThanEqualOrderByCreatedAtDesc(Integer lowestPrice, Pageable pageable);

	public Page<Restaurant> findByLowestPriceLessThanEqualOrderByLowestPriceAsc(Integer lowestPrice, Pageable pageable);

	//すべて取得
	public Page<Restaurant> findAllByOrderByCreatedAtDesc(Pageable pageable);

	public Page<Restaurant> findAllByOrderByLowestPriceAsc(Pageable pageable);

	//ホーム用10件表示
	public List<Restaurant> findTop6ByOrderByCreatedAtDesc();
}
