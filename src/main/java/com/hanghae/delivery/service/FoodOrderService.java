package com.hanghae.delivery.service;

import com.hanghae.delivery.domain.Food;
import com.hanghae.delivery.domain.FoodOrder;
import com.hanghae.delivery.domain.OrderList;
import com.hanghae.delivery.domain.Restaurant;
import com.hanghae.delivery.dto.FoodOrderDto;
import com.hanghae.delivery.dto.OrderDto;
import com.hanghae.delivery.dto.OrderRequestDto;
import com.hanghae.delivery.repository.FoodOrderRepository;
import com.hanghae.delivery.repository.FoodRepository;
import com.hanghae.delivery.repository.OrderListRepository;
import com.hanghae.delivery.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static com.hanghae.delivery.domain.ExceptionMessage.*;

@RequiredArgsConstructor
@Service
public class FoodOrderService {

    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;
    private final OrderListRepository orderListRepository;
    private final FoodOrderRepository foodOrderRepository;

    @Transactional // 해당 범위 내 메서드가 트랜잭션이 되도록 보장
    public OrderDto createOrders(OrderRequestDto orderRequestDto) {
        Restaurant restaurant = getRestaurant(orderRequestDto);

        int totalPrice = 0;
        List<FoodOrderDto> foodOrderDtoList = new ArrayList<>();
        List<OrderList> orderItems = orderRequestDto.getFoods();
        List<OrderList> orderItemList = new ArrayList<>();

        for (OrderList tempOrderList : orderItems) {
            int quantity = tempOrderList.getQuantity();
            // 주문 수량이 1보다 작거나 100보다 클 때 에러 발생
            if(quantity < 1 || quantity > 100) {
                try {
                    throw new IllegalAccessException(EXCEPTION_QUANTITY_ERROR);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }

            Food food = getFood(tempOrderList);

            OrderList orderList = OrderList.builder()
                    .quantity(tempOrderList.getQuantity())
                    .name(food.getName())
                    .price(food.getPrice() * quantity)
                    .food(food)
                    .build();
            orderListRepository.save(orderList);
            FoodOrderDto foodOrderDto = new FoodOrderDto(orderList);
            foodOrderDtoList.add(foodOrderDto);
            // 총 가격 = 음식 가격 * 수량
            totalPrice += food.getPrice() * quantity;
            orderItemList.add(orderList);
        }

        // 총 가격이 최소 주문 금액보다 낮을 때 에러 발생
        if (totalPrice < restaurant.getMinOrderPrice()) {
            try {
                throw new IllegalAccessException(EXCEPTION_TOTAL_MIN_PRICE_ERROR);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        int deliveryFee = restaurant.getDeliveryFee();

        // 총 가격 + 배달비
        totalPrice += deliveryFee;
        FoodOrder foodOrder = FoodOrder.builder()
                .restaurantName(restaurant.getName())
                .totalPrice(totalPrice)
                .foods(orderItemList)
                .build();

        foodOrderRepository.save(foodOrder);
        OrderDto orderDto = new OrderDto(foodOrder, deliveryFee, foodOrderDtoList);
        return orderDto;
    }

    private Food getFood(OrderList tempOrderList) {
        return foodRepository.findById(tempOrderList.getId()).orElseThrow(
                () -> new NullPointerException("음식을 찾을 수 없습니다.")
        );
    }

    private Restaurant getRestaurant(OrderRequestDto orderRequestDto) {
        Restaurant restaurant = restaurantRepository.findById(orderRequestDto.getRestaurantId()).orElseThrow(
                () -> new NullPointerException("음식점을 찾을 수 없습니다.")
        );
        return restaurant;
    }

    @Transactional
    public List<OrderDto> findAllOrder() {
        List<OrderDto> orderDtoList = new ArrayList<>();

        List<FoodOrder> ordersList = foodOrderRepository.findAll();
        for (FoodOrder foodOrder : ordersList) {
            int deliveryFee = restaurantRepository.findByName(foodOrder.getRestaurantName()).getDeliveryFee();
            List<FoodOrderDto> foodOrderDtoList = new ArrayList<>();
            List<OrderList> orderItemList = orderListRepository.findAll();
            for (OrderList orderList : orderItemList) {
                FoodOrderDto foodOrderDto = new FoodOrderDto(orderList);
                foodOrderDtoList.add(foodOrderDto);
            }
            OrderDto orderDto = new OrderDto(foodOrder, deliveryFee, foodOrderDtoList);
            orderDtoList.add(orderDto);
        }
        return orderDtoList;
    }
}
