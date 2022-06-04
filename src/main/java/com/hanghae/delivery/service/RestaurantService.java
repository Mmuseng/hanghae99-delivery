package com.hanghae.delivery.service;

import com.hanghae.delivery.domain.Food;
import com.hanghae.delivery.domain.Restaurant;
import com.hanghae.delivery.dto.FoodDto;
import com.hanghae.delivery.repository.FoodRepository;
import com.hanghae.delivery.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;
    private final FoodService foodService;

    public Restaurant findRestaurant (Long id) {
        return restaurantRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 매장입니다.")
        );
    }

    @Transactional
    public void addFoods (List<FoodDto> foodDto, Restaurant restaurant) {
        for (FoodDto food1 : foodDto) {
            Food food = new Food(food1,restaurant);
            restaurant.addFood(food);
            foodRepository.save(food);
        }

        restaurantRepository.save(restaurant);
    }
}
