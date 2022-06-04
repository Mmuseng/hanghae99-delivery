package com.hanghae.delivery.validator;

import com.hanghae.delivery.domain.Food;
import com.hanghae.delivery.domain.Restaurant;
import com.hanghae.delivery.dto.FoodDto;

public class FoodValidator {

    // 같은 음식점 내에서는 음식 이름이 중복될 수 없음
    public static void foodValidator(FoodDto foodDto, Restaurant restaurant) {

        if (restaurant.getFoods() != null) {
            for (Food food1 : restaurant.getFoods()) {
                if (food1.getName().equals(foodDto.getName())) {
                    System.out.println("기존 이름 :" + food1.getName() + "신메뉴 이름 :" + foodDto.getName());
                    try {
                        throw new IllegalAccessException("이미 등록된 메뉴입니다");
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        if (100 > foodDto.getPrice() || foodDto.getPrice() > 1000000) {
            try {
                throw new IllegalAccessException("가격이 허용값과 맞지 않습니다.");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        if (foodDto.getPrice()%100 != 0) {
            try {
                throw new IllegalAccessException("가격은 100원 단위로 입력해주세요.");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
