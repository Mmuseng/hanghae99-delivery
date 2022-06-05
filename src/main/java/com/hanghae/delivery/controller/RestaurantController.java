package com.hanghae.delivery.controller;

import com.hanghae.delivery.domain.Restaurant;
import com.hanghae.delivery.dto.RestaurantDto;
import com.hanghae.delivery.repository.RestaurantRepository;
import com.hanghae.delivery.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RestaurantController {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantService restaurantService;

    @PostMapping("/restaurant/register")
    // 음식점 등록
    public Restaurant createRestaurants(@RequestBody RestaurantDto requestDto) {
        System.out.println("음식점 등록 확인");
        return restaurantService.createRestaurants(requestDto);
    }

    @GetMapping("/restaurants")
    // 음식점 조회
    public List<Restaurant> getRestaurant() {
        System.out.println("음식점 조회");
        return restaurantRepository.findAll();
    }
}