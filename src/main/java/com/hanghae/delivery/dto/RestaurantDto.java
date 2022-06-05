package com.hanghae.delivery.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RestaurantDto {

    private String name;
    private int minOrderPrice;
    private int deliveryFee;

}
