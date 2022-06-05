package com.hanghae.delivery.dto;

import com.hanghae.delivery.domain.FoodOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderDto {

    private String restaurantName;
    private List<FoodOrderDto> foods;
    private int deliveryFee;
    private int totalPrice;

    public OrderDto(FoodOrder foodOrder, int deliveryFee, List<FoodOrderDto> foodOrderDtoList) {
        this.restaurantName = foodOrder.getRestaurantName();
        this.foods = foodOrderDtoList;
        this.deliveryFee = deliveryFee;
        this.totalPrice = foodOrder.getTotalPrice();
    }
}
