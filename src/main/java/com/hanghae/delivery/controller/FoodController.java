package com.hanghae.delivery.controller;

import com.hanghae.delivery.domain.Food;
import com.hanghae.delivery.dto.FoodDto;
import com.hanghae.delivery.repository.FoodRepository;
import com.hanghae.delivery.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FoodController {
    private final FoodRepository foodRepository;
    private final FoodService foodService;

    @PostMapping("/restaurant/{restaurantId}/food/register")
    // 음식 등록
    public void createFoods (@PathVariable Long restaurantId, @RequestBody List<FoodDto> requestDto) {
        System.out.println(restaurantId +"번 음식점 음식 등록");
        foodService.createFoods(restaurantId, requestDto);
    }

    @GetMapping("/restaurant/{restaurantId}/foods")
    // 메뉴판 조회
    public List<Food> getFood(@PathVariable Long restaurantId) {
        System.out.println(restaurantId + "번 음식점 메뉴판 조회");
        return foodRepository.findAllByRestaurantId(restaurantId);
    }
}
