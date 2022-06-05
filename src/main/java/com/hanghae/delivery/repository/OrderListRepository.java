package com.hanghae.delivery.repository;

import com.hanghae.delivery.domain.FoodOrder;
import com.hanghae.delivery.domain.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderListRepository extends JpaRepository<OrderList, Long> {

    List<OrderList> findOrderListByFoodOrder (FoodOrder foodOrder);
}
