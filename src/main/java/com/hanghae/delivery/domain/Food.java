package com.hanghae.delivery.domain;

import com.hanghae.delivery.dto.FoodDto;
import com.hanghae.delivery.validator.FoodValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Food {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    // 음식명
    private String name;

    @Column(nullable = false)
    // 가격
    private int price;

    @ManyToOne
    //음식점 테이블과 조인
    @JoinColumn(name = "RESTAURANT_ID")
    private Restaurant restaurant;

    public Food (FoodDto foodDto, Restaurant restaurant) {
        FoodValidator.foodValidator(foodDto, restaurant);
        this.name = foodDto.getName();
        this.price = foodDto.getPrice();
    }

}
