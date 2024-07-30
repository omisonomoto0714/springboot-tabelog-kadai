package com.example.nagoyamesi.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.nagoyamesi.entity.Category;
import com.example.nagoyamesi.entity.Favorite;
import com.example.nagoyamesi.entity.Restaurant;
import com.example.nagoyamesi.entity.Review;
import com.example.nagoyamesi.entity.User;
import com.example.nagoyamesi.form.ReservationInputForm;
import com.example.nagoyamesi.repository.CategoryRepository;
import com.example.nagoyamesi.repository.FavoriteRepository;
import com.example.nagoyamesi.repository.RestaurantRepository;
import com.example.nagoyamesi.repository.ReviewRepository;
import com.example.nagoyamesi.security.UserDetailsImpl;
import com.example.nagoyamesi.service.FavoriteService;
import com.example.nagoyamesi.service.ReviewService;

@Controller
@RequestMapping("restaurants")
public class RestaurantController {
	private final RestaurantRepository restaurantRepository;
	private final ReviewRepository reviewRepository;
	private final ReviewService reviewService;
	private final FavoriteService favoriteService;
	private final FavoriteRepository favoriteRepository;
	private final CategoryRepository categoryRepository;

	public RestaurantController(RestaurantRepository restaurantRepository, ReviewRepository reviewRepository,
			ReviewService reviewService, FavoriteService favoriteService, FavoriteRepository favoriteRepository,
			CategoryRepository categoryRepository) {
		this.restaurantRepository = restaurantRepository;
		this.reviewRepository = reviewRepository;
		this.reviewService = reviewService;
		this.favoriteService = favoriteService;
		this.favoriteRepository = favoriteRepository;
		this.categoryRepository = categoryRepository;
	}

	@GetMapping
	public String index(@RequestParam(name = "keyword", required = false) String keyword,
			@RequestParam(name = "aria", required = false) String area,
			@RequestParam(name = "lowestPrice", required = false) Integer lowestPrice,
			@RequestParam(name = "order", required = false) String order,
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable,
			Model model) {
		Page<Restaurant> restaurantPage;
		List<Category> category = categoryRepository.findAll();

		if (keyword != null && !keyword.isEmpty()) {
			if (order != null && order.equals("lowestPrice")) {
				restaurantPage = restaurantRepository.findByNameLikeOrAddressLikeOrderByLowestPriceAsc(
						"%" + keyword + "%", "%" + keyword + "%", pageable);
			} else {
				restaurantPage = restaurantRepository.findByNameLikeOrAddressLikeOrderByCreatedAtDesc(
						"%" + keyword + "%", "%" + keyword + "%", pageable);
			}

		} else if (lowestPrice != null) {
			if (order != null && order.equals("lowestPriceAsc")) {
				restaurantPage = restaurantRepository.findByLowestPriceLessThanEqualOrderByLowestPriceAsc(lowestPrice,
						pageable);
			} else {
				restaurantPage = restaurantRepository.findByLowestPriceLessThanEqualOrderByCreatedAtDesc(lowestPrice,
						pageable);
			}
		} else {
			if (order != null && order.equals("lowestPrice")) {
				restaurantPage = restaurantRepository.findAllByOrderByLowestPriceAsc(pageable);
			} else {
				restaurantPage = restaurantRepository.findAllByOrderByCreatedAtDesc(pageable);
			}
		}

		model.addAttribute("restaurantPage", restaurantPage);
		model.addAttribute("category", category);
		model.addAttribute("keyword", keyword);
		model.addAttribute("lowestPrice", lowestPrice);
		model.addAttribute("order", order);

		return "restaurants/index";
	}

	@GetMapping("{id}")
	public String show(@PathVariable(name = "id") Integer id, Model model,
			@AuthenticationPrincipal UserDetailsImpl userDetailsImpl) {

		Restaurant restaurant = restaurantRepository.getReferenceById(id);
		List<Category> categoryList = categoryRepository.findAll();
		Favorite favorite = null;
		boolean hasUserAlreadyReviewed = false;
		boolean isFavorite = false;

		if (userDetailsImpl != null) {
			User user = userDetailsImpl.getUser();
			hasUserAlreadyReviewed = reviewService.hasUserAlreadyReviewed(restaurant, user);
			isFavorite = favoriteService.isFavorite(restaurant, user);
			if (isFavorite) {
				favorite = favoriteRepository.findByRestaurantAndUser(restaurant, user);
			}

		}

		List<Review> newReviews = reviewRepository.findTop6ByRestaurantOrderByCreatedAtDesc(restaurant);
		long totalReviewCount = reviewRepository.countByRestaurant(restaurant);

		model.addAttribute("restaurant", restaurant);
		model.addAttribute("reservationInputForm", new ReservationInputForm());
		model.addAttribute("hasUserAlreadyReviewed", hasUserAlreadyReviewed);
		model.addAttribute("newReviews", newReviews);
		model.addAttribute("totalReviewCount", totalReviewCount);
		model.addAttribute("favorite", favorite);
		model.addAttribute("isFavorite", isFavorite);
		model.addAttribute("categoryList", categoryList);

		return "restaurants/show";
	}

}
