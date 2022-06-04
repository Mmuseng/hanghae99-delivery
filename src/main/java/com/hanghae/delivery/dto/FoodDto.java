package com.hanghae.delivery.dto;

import com.hanghae.delivery.domain.Food;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FoodDto {

    private Long id;

    private String name;

    private int price;

    public FoodDto (Food foods) {
        this.setId(foods.getId());
        this.setName(foods.getName());
        this.setPrice(foods.getPrice());
    }
}
