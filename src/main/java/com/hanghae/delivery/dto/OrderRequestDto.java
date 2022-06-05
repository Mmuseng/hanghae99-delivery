package com.hanghae.delivery.dto;

import com.hanghae.delivery.domain.OrderList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderRequestDto {

    private Long restaurantId;
    private List<OrderList> foods;

}
