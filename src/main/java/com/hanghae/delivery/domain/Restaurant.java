package com.hanghae.delivery.domain;

import com.hanghae.delivery.dto.RestaurantDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    public Restaurant (RestaurantDto requestDto) {
        this.name = requestDto.getName();
        this.minOrderPrice = requestDto.getMinOrderPrice();
        this.deliveryFee = requestDto.getDeliveryFee();
    }

}
