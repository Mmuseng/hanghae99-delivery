package com.hanghae.delivery.validator;

import com.hanghae.delivery.dto.RestaurantDto;
import org.springframework.stereotype.Component;

@Component
public class RestaurantValidator {

    public static void restaurantValidator(RestaurantDto restaurantDto) {
        // 최소 주문 가격 (minOrderPrice)
        // 허용값: 1,000원 ~ 100,000원 입력
        // 100원 단위로만 입력 가능
        if (1000 > restaurantDto.getMinOrderPrice() || restaurantDto.getMinOrderPrice() > 100000) {
            try {
                throw new IllegalAccessException("최소 주문가격이 허용값과 맞지 않습니다.");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        if (restaurantDto.getMinOrderPrice()%100 != 0) {
            try {
                throw new IllegalAccessException("최소 주문가격은 100원 단위로 입력 해주세요.");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        // 기본 배달비 (deliiveryFee)
        // 허용값: 0원 ~ 10,000원
        // 500원 단위로만 입력 가능
        if(0 > restaurantDto.getDeliveryFee() || restaurantDto.getDeliveryFee() > 10000) {
            try {
                throw new IllegalAccessException("배달비가 허용값과 맞지 않습니다.");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        if (restaurantDto.getDeliveryFee()%500 != 0) {
            try {
                throw new IllegalAccessException("배달비는 500원 단위로 입력 해주세요.");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
