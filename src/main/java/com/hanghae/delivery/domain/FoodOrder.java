package com.hanghae.delivery.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class FoodOrder {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    // 음식점 이름
    private String restaurantName;

    @Column(nullable = false)
    // 총 가격
    private int totalPrice;

    @OneToMany(cascade = CascadeType.ALL) // 매핑 당하는 쪽
    @JoinColumn(name = "Order_id") // order_id 조인
    private List<OrderList> foods;
}
