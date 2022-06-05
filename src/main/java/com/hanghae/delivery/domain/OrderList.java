package com.hanghae.delivery.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class OrderList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    // 주문 수량
    private int quantity;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    // 가격
    private int price;

    @ManyToOne // Food 테이블과 매핑
    private Food food;

    @ManyToOne // FoodOrder 테이블과 매핑
    private FoodOrder foodOrder;
}
