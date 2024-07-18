package com.example.nagoyamesi.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.nagoyamesi.entity.Restaurant;
import com.example.nagoyamesi.form.RestaurantEditForm;
import com.example.nagoyamesi.form.RestaurantRegisterForm;
import com.example.nagoyamesi.repository.CategoryRepository;
import com.example.nagoyamesi.repository.RestaurantRepository;

@Service
public class RestaurantService {
	private final RestaurantRepository restaurantRepository;
	private final CategoryRepository categoryRepository;

	public RestaurantService(RestaurantRepository restaurantRepository, CategoryRepository categoryRepository) {
		this.restaurantRepository = restaurantRepository;
		this.categoryRepository = categoryRepository;
	}

	@Transactional
	public void create(RestaurantRegisterForm restaurantRegisterForm) {
		Restaurant restaurant = new Restaurant();
		MultipartFile imageFile = restaurantRegisterForm.getImageFile();

		if (!imageFile.isEmpty()) {
			String imageName = imageFile.getOriginalFilename();
			String hashedImageName = generateNewFileName(imageName);
			Path filePath = Paths.get("src/main/resources/static/storage/" + hashedImageName);
			copyImageFile(imageFile, filePath);
			restaurant.setImageName(hashedImageName);

		}

		restaurant.setName(restaurantRegisterForm.getName());
		restaurant.setDescription(restaurantRegisterForm.getDescription());
		restaurant.setOpeningTime(restaurantRegisterForm.getOpeningTime());
		restaurant.setClosingTime(restaurantRegisterForm.getClosingTime());
		restaurant.setLowestPrice(restaurantRegisterForm.getLowestPrice());
		restaurant.setHighestPrice(restaurantRegisterForm.getHighestPrice());
		restaurant.setPostalCode(restaurantRegisterForm.getPostalCode());
		restaurant.setAddress(restaurantRegisterForm.getAddress());
		restaurant.setPhoneNumber(restaurantRegisterForm.getPhoneNumber());
		restaurant.setCategoryId(restaurantRegisterForm.getCategoryId());

		restaurantRepository.save(restaurant);
	}

	@Transactional
	public void update(RestaurantEditForm restaurantEditForm) {
		Restaurant restaurant = restaurantRepository.getReferenceById(restaurantEditForm.getId());
		MultipartFile imageFile = restaurantEditForm.getImageFile();

		if (!imageFile.isEmpty()) {
			String imageName = imageFile.getOriginalFilename();
			String hashedImageName = generateNewFileName(imageName);
			Path filePath = Paths.get("src/main/resources/static/storage/" + hashedImageName);
			copyImageFile(imageFile, filePath);
			restaurant.setImageName(hashedImageName);
		}

		restaurant.setName(restaurantEditForm.getName());
		restaurant.setDescription(restaurantEditForm.getDescription());
		restaurant.setOpeningTime(restaurantEditForm.getOpeningTime());
		restaurant.setClosingTime(restaurantEditForm.getClosingTime());
		restaurant.setLowestPrice(restaurantEditForm.getLowestPrice());
		restaurant.setHighestPrice(restaurantEditForm.getHighestPrice());
		restaurant.setPostalCode(restaurantEditForm.getPostalCode());
		restaurant.setAddress(restaurantEditForm.getAddress());
		restaurant.setPhoneNumber(restaurantEditForm.getPhoneNumber());
		restaurant.setCategoryId(restaurantEditForm.getCategoryId());

		restaurantRepository.save(restaurant);
	}

	public String generateNewFileName(String fileName) {
		String[] fileNames = fileName.split("\\.");
		for (int i = 0; i < fileNames.length - 1; i++) {
			fileNames[i] = UUID.randomUUID().toString();
		}
		String hashedFileName = String.join(".", fileNames);
		return hashedFileName;
	}

	public void copyImageFile(MultipartFile imageFile, Path filePath) {
		try {
			Files.copy(imageFile.getInputStream(), filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
