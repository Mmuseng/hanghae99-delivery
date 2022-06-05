package com.hanghae.delivery.dto;

import com.hanghae.delivery.domain.OrderList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FoodOrderDto {

    private String name;
    private int quantity;
    private int price;

    public FoodOrderDto(OrderList orderList) {
        this.name = orderList.getName();
        this.quantity = orderList.getQuantity();
        this.price = orderList.getPrice();
    }

}
