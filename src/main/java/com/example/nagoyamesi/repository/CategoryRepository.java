package com.example.nagoyamesi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyamesi.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	//ページネーション用取得
	public Page<Category> findAllByOrderByCreatedAtDesc(Pageable pageable);

	//検索用
	public Page<Category> findByCategoryNameLike(String keyword, Pageable pageable);

	public Category findByCategoryName(String categoryName);
}
