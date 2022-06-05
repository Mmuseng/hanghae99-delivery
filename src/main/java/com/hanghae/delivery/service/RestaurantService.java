package com.hanghae.delivery.service;
import com.hanghae.delivery.domain.Restaurant;
import com.hanghae.delivery.dto.RestaurantDto;
import com.hanghae.delivery.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.hanghae.delivery.domain.ExceptionMessage.*;

@RequiredArgsConstructor
@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public Restaurant createRestaurants(RestaurantDto requestDto) {
        int minCheck = requestDto.getMinOrderPrice();
        int feeCheck = requestDto.getDeliveryFee();

        Restaurant restaurant = new Restaurant(requestDto);

        if (minCheck < 1000 || minCheck > 100000) {
            throw new IllegalArgumentException(EXCEPTION_MIN_PRICE_ERROR);
        }
        else if(minCheck%100 != 0) {
            throw new IllegalArgumentException(EXCEPTION_MIN_UNIT_ERROR);
        }
        // 배달비가 0원 이하 이거나 10,000원 이상 일때 에러 발생
        else if(feeCheck < 0 || feeCheck > 10000){
            throw new IllegalArgumentException(EXCEPTION_FEE_PRICE_ERROR);
        }
        // 배달비를 500으로 나누었을 때 값이 0이 아니면 에러 발생 (500원 단위로만 입력 가능)
        else if(feeCheck%500 !=0) {
            throw new IllegalArgumentException(EXCEPTION_FEE_UNIT_ERROR);
        }
        return restaurantRepository.save(restaurant);
    }

}