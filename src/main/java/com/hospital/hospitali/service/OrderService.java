package com.hospital.hospitali.service;

import com.hospital.hospitali.dto.OrderDto;

import java.util.List;

public interface OrderService {
    void placeOrder(OrderDto orderDto);
    List<OrderDto> getOrderHistory(Long userId);

    OrderDto getOrderDetails(Long orderId);
}