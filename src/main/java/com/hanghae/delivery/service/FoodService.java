package com.hanghae.delivery.service;

import com.hanghae.delivery.domain.Food;
import com.hanghae.delivery.dto.FoodDto;
import com.hanghae.delivery.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import static com.hanghae.delivery.domain.ExceptionMessage.*;

@RequiredArgsConstructor
@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public void createFoods(Long id, List<FoodDto> requestDtoList) {
        List<Food> foodList = foodRepository.findAllByRestaurantId(id);

        for (int i = 0; i < foodList.size(); i++) {
            for (int j = i + 1; j < requestDtoList.size(); j++) {
                if (foodList.get(i).getName().equals(requestDtoList.get(j - 1).getName())) {
                    throw new IllegalArgumentException(EXCEPTION_SAME_MENU_ERROR);
                } else if (requestDtoList.get(i).getName().equals(requestDtoList.get(j).getName())) {
                    throw new IllegalArgumentException(EXCEPTION_DUPLE_MENU_ERROR);
                }
            }
        }

        for (FoodDto requestDto : requestDtoList) {
            int foodMinCheck = requestDto.getPrice();
            Food result = new Food(id, requestDto);

            if (foodMinCheck < 100 || foodMinCheck > 1000000) {
                throw new IllegalArgumentException(EXCEPTION_MIN_MENU_ERROR);
            } else if (foodMinCheck % 100 != 0) {
                throw new IllegalArgumentException(EXCEPTION_UNIT_MENU_ERROR);
            }
            foodRepository.save(result);
        }
    }

}
