package com.hanghae.delivery.controller;

import com.hanghae.delivery.dto.OrderDto;
import com.hanghae.delivery.dto.OrderRequestDto;
import com.hanghae.delivery.repository.FoodOrderRepository;
import com.hanghae.delivery.service.FoodOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FoodOrderController {

    private final FoodOrderRepository foodOrderRepository;
    private final FoodOrderService foodOrderService;

    @PostMapping("/order/request")
    public OrderDto createOrders (@RequestBody OrderRequestDto orderRequestDto) {
        return foodOrderService.createOrders(orderRequestDto);
    }

    @GetMapping("/orders")
    public List<OrderDto> findAllOrder() {

        return foodOrderService.findAllOrder();
    }
}
