package com.hanghae.delivery.domain;

import com.hanghae.delivery.dto.RestaurantDto;
import com.hanghae.delivery.validator.RestaurantValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Restaurant {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    // 음식점 이름
    private String name;

    @Column(nullable = false)
    // 최소 주문 금액
    private int minOrderPrice;

    @Column(nullable = false)
    // 배달비
    private int deliveryFee;

    @OneToMany(mappedBy = "restaurant") // 음식 테이블과 매핑
    private List<Food> foods;

    public Restaurant (RestaurantDto restaurantDto) { // 최소 주문금액 배달료 규칙 메소드

        RestaurantValidator.restaurantValidator(restaurantDto);

        this.name = restaurantDto.getName();
        this.minOrderPrice = restaurantDto.getMinOrderPrice();
        this.deliveryFee = restaurantDto.getDeliveryFee();
    }

    public void addFood(Food food) { // 음식 추가 메소드

        food.setRestaurant(this);
        this.foods.add(food);
    }
}
