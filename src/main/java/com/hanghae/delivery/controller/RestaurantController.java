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
    public Restaurant createRestaurants(@RequestBody RestaurantDto requestDto) {
        return restaurantService.createRestaurants(requestDto);
    }

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurant() {

        return restaurantRepository.findAll();
    }
}