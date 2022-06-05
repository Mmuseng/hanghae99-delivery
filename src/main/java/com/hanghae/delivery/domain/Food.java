package com.hanghae.delivery.domain;

import com.hanghae.delivery.dto.FoodDto;
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

    @Column(nullable = false)
    private Long restaurantId;

    public Food (Long id, FoodDto requestDto){
        this.name = requestDto.getName();
        this.price = requestDto.getPrice();
        this.restaurantId = id;
    }

}
