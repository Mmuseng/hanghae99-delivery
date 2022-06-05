package com.hanghae.delivery.repository;

import com.hanghae.delivery.domain.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long> {

    List<FoodOrder> findAllById(Long id);
}
