package com.hanghae.delivery.service;

import com.hanghae.delivery.domain.Food;
import com.hanghae.delivery.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public Food findFood (Long id) {
        return foodRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 메뉴입니다.")
        );
    }

}
