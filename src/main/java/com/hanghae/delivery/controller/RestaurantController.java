package com.hanghae.delivery.controller;

import com.hanghae.delivery.domain.Restaurant;
import com.hanghae.delivery.dto.FoodDto;
import com.hanghae.delivery.dto.RestaurantDto;
import com.hanghae.delivery.repository.FoodRepository;
import com.hanghae.delivery.repository.RestaurantRepository;
import com.hanghae.delivery.service.FoodService;
import com.hanghae.delivery.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final RestaurantRepository restaurantRepository;
    private final FoodService foodService;
    private final FoodRepository foodRepository;

    // 음식점 등록
    @PostMapping("/restaurant/register")
    public Restaurant joinRestaurant (@RequestBody RestaurantDto restaurantDto) {
        System.out.println("음식점 등록 확인");
        Restaurant restaurant = new Restaurant(restaurantDto);
        restaurantRepository.save(restaurant);
        return restaurant;
    }

    // 음식점 조회
    @GetMapping("/restaurants")
    public List<Restaurant> allRestaurant() {
        System.out.println("음식점 조회 확인");
        return restaurantRepository.findAll();

    }

    // 하나의 음식점에 음식 등록
    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void saveFood (@PathVariable Long restaurantId, @RequestBody List<FoodDto> foodDto) {
        System.out.println("음식 등록 확인");
        System.out.println(restaurantId);
        Restaurant restaurant = restaurantService.findRestaurant(restaurantId);
        System.out.println("현재 음식점 메뉴 수" + restaurantService.findRestaurant(restaurantId).getFoods().size());
        restaurantService.addFoods(foodDto, restaurant);

        System.out.println("저장 후 음식점 메뉴 수" + restaurantService.findRestaurant(restaurantId).getFoods().size());

    }

    // 하나의 음식점에 등록된 모든 음식 정보 조회
    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<FoodDto> foodList (@PathVariable Long restaurantId) {
        System.out.println("리스트 조회 " + restaurantId);
        Restaurant restaurant = restaurantService.findRestaurant(restaurantId);
        RestaurantDto restaurantDto = new RestaurantDto(restaurant, restaurant.getFoods());

        return restaurantDto.getFoods();
    }
}
